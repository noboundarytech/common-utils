package tech.noboundary.common.check.ruler.support

import tech.noboundary.common.check.CheckResultCodeEnum.BYTE_EQ_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.BYTE_GTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.BYTE_GT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.BYTE_LTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.BYTE_LT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.BYTE_NOT_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.BYTE_NULL_FAIL
import tech.noboundary.common.check.and
import tech.noboundary.common.check.ruler.Ruler
import tech.noboundary.common.utils.NumberUtil

object ByteRuler {
    val notNull = notNull()
    val beNull = beNull()

    fun beNull(code: Long = BYTE_NULL_FAIL.code, desc: String = BYTE_NULL_FAIL.desc)
            = Ruler.ofBeNull<Byte?>(code, desc)

    fun notNull(code: Long = BYTE_NOT_NULL_FAIL.code, desc: String = BYTE_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Byte?>(code, desc)

    fun eq(norm: Byte, code: Long = BYTE_EQ_FAIL.code, desc: String = BYTE_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isEq)

    fun gt(norm: Byte, code: Long = BYTE_GT_FAIL.code, desc: String = BYTE_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isGt)

    fun gte(norm: Byte, code: Long = BYTE_GTE_FAIL.code, desc: String = BYTE_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isGte)

    fun lt(norm: Byte, code: Long = BYTE_LT_FAIL.code, desc: String = BYTE_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isLt)

    fun lte(norm: Byte, code: Long = BYTE_LTE_FAIL.code, desc: String = BYTE_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, NumberUtil::isLte)
}