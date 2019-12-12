package tech.noboundary.common.terminate

import org.slf4j.LoggerFactory

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
 * @author liurenpeng
 * Created on 2019-12-02
 */
object TerminateHelper {
    private val logger = LoggerFactory.getLogger(this::class.java)

    private val SLEEP_SECONDS_BEFORE_EXIT = 5

    //private val terms = ConcurrentLinkedDeque<ThrowableRunnable<out Throwable>>()

}
 