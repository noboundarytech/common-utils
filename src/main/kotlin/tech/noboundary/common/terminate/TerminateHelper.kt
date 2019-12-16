package tech.noboundary.common.terminate

import com.google.common.util.concurrent.Uninterruptibles.awaitUninterruptibly
import com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly
import org.slf4j.LoggerFactory
import sun.misc.Signal
import java.util.concurrent.ConcurrentLinkedDeque
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 程序退出辅助工具
 * 为避免手动注册 TERM Signal 导致相互覆盖，所以对此类需求统一管理,
 * 可以把所有的任务存入一个双向队列, 在收到 TERM Signal 以后依次调用并退出.
 * 使用者只需要 {@link #addTerm} 或者 {@link #addFirstTerm} 把自己的事件加入队列即可.
 *
 * 不使用 {@link Runtime#addShutdownHook(Thread)} API 的原因:
 *  1. ShutdownHook的执行顺序无法保障，且第三方组件也可能注册，导致业务自定义的退出流程依赖的资源被提前关闭和清理
 *  2. TerminateHelper使用非公开API，第三方组件不会注册，且可以完整托管任务的执行顺序
 *  3. 正常ShutdownHook会在执行完TerminateHelper时调用，保证资源的清理不会影响业务的退出清理逻辑
 *
 *  TODO reportOutOfMemoryError意义何在？
 * @author liurenpeng
 * Created on 2019-12-02
 */
object TerminateHelper {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private const val SUCCESS_EXIT_CODE = 0
    private const val EXCEPTION_EXIT_CODE = 1
    private const val sleepSecondsBeforeExit = 5L // TODO 超过是否会强制退出
    private val terms = ConcurrentLinkedDeque<() -> Unit>()
    private val isRegistered = AtomicBoolean(false)
    private val isStopping = AtomicBoolean(false)
    private val stoppedLatch = CountDownLatch(1)
    private val isNeedSleepBeforeExit = AtomicBoolean(false)
    private val isSignalTriggered = AtomicBoolean(false)

    fun addTerm(term: () -> Unit) {
        tryRegisterOnlyOnce()
        terms.addLast(term)
    }

    fun addFirstTerm(term: () -> Unit) {
        tryRegisterOnlyOnce()
        terms.addFirst(term)
    }

    /**
     * 是否已经开始Term流程
     */
    fun isStopping() = isStopping.get()

    /**
     * 类似于 kafka producer，有 buffer 需要被输出的情况下使用
     */
    fun setNeedSleepBeforeExit() {
        tryRegisterOnlyOnce()
        isNeedSleepBeforeExit.set(true)
    }

    fun doTerm() {
        if (isStopping.getAndSet(true)) {
            logger.warn("term routine already running.")
            awaitUninterruptibly(stoppedLatch)
            return
        }
        terms.forEach {
            try {
                logger.info("execute term:{}", it)
                it.invoke()
            } catch (e: Exception) {
                logger.error("fail to exec term:{}", it, e)
            }
        }
        if (isNeedSleepBeforeExit.get()) {
            sleepUninterruptibly(sleepSecondsBeforeExit, TimeUnit.SECONDS)
        }
        stoppedLatch.countDown()
    }

    private fun tryRegisterOnlyOnce() {
        val previousUnRegistered = !isRegistered.getAndSet(true)
        if (previousUnRegistered) {
            registerUser2AndTermSingle()
        }
    }

    /**
     * 处理Usr2和Term信号
     */
    private fun registerUser2AndTermSingle() {
        val handler = fun(_: Signal) {
            // Usr2、Term共用一个原子变量，以便如果其中一个已响应，则另一个直接跳过
            if (isSignalTriggered.getAndSet(true)) {
                logger.warn("Usr2 or Term has been triggered.")
                return
            }
            termAndExit()
        }
        Signal.handle(Signal("USR2"), handler)
        Signal.handle(Signal("TERM"), handler)
    }

    private fun termAndExit() {
        var exitCode = SUCCESS_EXIT_CODE
        try {
            Thread.currentThread().name += "(退出线程)"
            logger.info("do term cleanup.")
            doTerm()
            logger.info("exit success.")
        } catch (e: Exception) {
            exitCode = EXCEPTION_EXIT_CODE
            logger.error("exit error.", e)
        } finally {
            System.exit(exitCode)
        }
    }
}
