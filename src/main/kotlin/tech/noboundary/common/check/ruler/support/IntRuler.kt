package tech.noboundary.common.check.ruler.support

import tech.noboundary.common.check.CheckResultCodeEnum.INT_EQ_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.INT_GTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.INT_GT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.INT_LTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.INT_LT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.INT_NOT_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.INT_NULL_FAIL
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
object IntRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = INT_NULL_FAIL.code, desc: String = INT_NULL_FAIL.desc)
            = Ruler.ofBeNull<Int?>(code, desc)

    fun notNull(code: Long = INT_NOT_NULL_FAIL.code, desc: String = INT_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Int?>(code, desc)

    fun eq(norm: Int, code: Long = INT_EQ_FAIL.code, desc: String = INT_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isEq)

    fun gt(norm: Int, code: Long = INT_GT_FAIL.code, desc: String = INT_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGt)

    fun gte(norm: Int, code: Long = INT_GTE_FAIL.code, desc: String = INT_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGte)

    fun lt(norm: Int, code: Long = INT_LT_FAIL.code, desc: String = INT_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLt)

    fun lte(norm: Int, code: Long = INT_LTE_FAIL.code, desc: String = INT_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLte)
}