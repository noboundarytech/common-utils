package tech.noboundary.common.check.ruler.support

import tech.noboundary.common.check.CheckResultCodeEnum.ANY_NOT_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ANY_NULL_FAIL
import tech.noboundary.common.check.ruler.Ruler

object AnyRuler {
    val beNull = beNull()
    val notNull = notNull()

    fun beNull(code: Long = ANY_NULL_FAIL.code, desc: String = ANY_NULL_FAIL.desc)
            = Ruler.ofBeNull<Any?>(code, desc)

    fun notNull(code: Long = ANY_NOT_NULL_FAIL.code, desc: String = ANY_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Any?>(code, desc)
}