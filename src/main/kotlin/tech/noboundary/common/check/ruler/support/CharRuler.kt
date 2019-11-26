package tech.noboundary.common.check.ruler.support

import tech.noboundary.common.check.CheckResultCodeEnum.CHAR_EQ_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.CHAR_GTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.CHAR_GT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.CHAR_LTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.CHAR_LT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.CHAR_NOT_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.CHAR_NULL_FAIL
import tech.noboundary.common.check.and
import tech.noboundary.common.check.ruler.Ruler
import tech.noboundary.common.utils.CharUtil.isEq
import tech.noboundary.common.utils.CharUtil.isGt
import tech.noboundary.common.utils.CharUtil.isGte
import tech.noboundary.common.utils.CharUtil.isLt
import tech.noboundary.common.utils.CharUtil.isLte

/**
 * @author: liurenpeng
 * @date: Created in 18-7-24
 */
object CharRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = CHAR_NULL_FAIL.code, desc: String = CHAR_NULL_FAIL.desc)
            = Ruler.ofBeNull<Char?>(code, desc)

    fun notNull(code: Long = CHAR_NOT_NULL_FAIL.code, desc: String = CHAR_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Char?>(code, desc)

    fun eq(norm: Char, code: Long = CHAR_EQ_FAIL.code, desc: String = CHAR_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isEq)

    fun gt(norm: Char, code: Long = CHAR_GT_FAIL.code, desc: String = CHAR_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGt)

    fun gte(norm: Char, code: Long = CHAR_GTE_FAIL.code, desc: String = CHAR_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isGte)

    fun lt(norm: Char, code: Long = CHAR_LT_FAIL.code, desc: String = CHAR_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLt)

    fun lte(norm: Char, code: Long = CHAR_LTE_FAIL.code, desc: String = CHAR_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLte)
}