package tech.noboundary.common.terminate

import java.util.concurrent.TimeUnit

/**
 * @author liurenpeng
 * Created on 2019-12-16
 */

class TerminateHelperTest {
}

fun main() {
    TerminateHelper.addTerm {
        println("print term start")
        TimeUnit.SECONDS.sleep(10)
        println("print term end")
    }
    TerminateHelper.addFirstTerm { println("first term") }
    TerminateHelper.doTerm()
    Thread.sleep(Long.MAX_VALUE)
}