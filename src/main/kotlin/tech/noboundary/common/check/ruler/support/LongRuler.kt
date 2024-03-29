package tech.noboundary.common.check.ruler.support

import tech.noboundary.common.check.CheckResultCodeEnum.LONG_EQ_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.LONG_GTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.LONG_GT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.LONG_LTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.LONG_LT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.LONG_NOT_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.LONG_NULL_FAIL
import tech.noboundary.common.check.and
import tech.noboundary.common.check.ruler.Ruler
import tech.noboundary.common.utils.NumberUtil.isEq
import tech.noboundary.common.utils.NumberUtil.isGt
import tech.noboundary.common.utils.NumberUtil.isGte
import tech.noboundary.common.utils.NumberUtil.isLt
import tech.noboundary.common.utils.NumberUtil.isLte

/**
 * @author: liurenpeng
 * @date: Created in 18-7-13
 */
object LongRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = LONG_NULL_FAIL.code, desc: String = LONG_NULL_FAIL.desc)
            = Ruler.ofBeNull<Long?>(code, desc)

    fun notNull(code: Long = LONG_NOT_NULL_FAIL.code, desc: String = LONG_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Long?>(code, desc)

    fun eq(norm: Long, code: Long = LONG_EQ_FAIL.code, desc: String = LONG_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isEq)

    fun gt(norm: Long, code: Long = LONG_GT_FAIL.code, desc: String = LONG_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGt)

    fun gte(norm: Long, code: Long = LONG_GTE_FAIL.code, desc: String = LONG_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGte)

    fun lt(norm: Long, code: Long = LONG_LT_FAIL.code, desc: String = LONG_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLt)

    fun lte(norm: Long, code: Long = LONG_LTE_FAIL.code, desc: String = LONG_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLte)
}