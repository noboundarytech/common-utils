package tech.noboundary.common.check.ruler.support

import tech.noboundary.common.check.CheckResultCodeEnum.ARR_LENGTH_EQ_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_LENGTH_GTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_LENGTH_GT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_LENGTH_LTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_LENGTH_LT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_NOT_CONTAINS_DUP_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_NOT_CONTAINS_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_NOT_EMPTY_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_NOT_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.ARR_NULL_FAIL
import tech.noboundary.common.check.and
import tech.noboundary.common.check.ruler.Ruler
import tech.noboundary.common.utils.ArrayUtil.isLengthEq
import tech.noboundary.common.utils.ArrayUtil.isLengthGt
import tech.noboundary.common.utils.ArrayUtil.isLengthGte
import tech.noboundary.common.utils.ArrayUtil.isLengthLt
import tech.noboundary.common.utils.ArrayUtil.isLengthLte
import tech.noboundary.common.utils.ArrayUtil.isNotContainsDup
import tech.noboundary.common.utils.ArrayUtil.isNotContainsNull
import tech.noboundary.common.utils.ArrayUtil.isNotEmpty

/**
 * @author: liurenpeng
 * @date: Created in 18-7-12
 */
object ArrRuler {

    val beNull = beNull()
    val notNull = notNull()
    val notEmpty = notEmpty()
    val notContainsNull = notContainsNull()
    val notContainsDup = notContainsDup()

    fun beNull(code: Long = ARR_NULL_FAIL.code, desc: String = ARR_NULL_FAIL.desc)
            = Ruler.ofBeNull<Array<*>?>(code, desc)

    fun notNull(code: Long = ARR_NOT_NULL_FAIL.code, desc: String = ARR_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<Array<*>?>(code, desc)

    fun notEmpty(code: Long = ARR_NOT_EMPTY_FAIL.code, desc: String = ARR_NOT_EMPTY_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotEmpty)

    fun lengthEq(norm: Int, code: Long = ARR_LENGTH_EQ_FAIL.code, desc: String = ARR_LENGTH_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthEq)

    fun lengthGt(norm: Int, code: Long = ARR_LENGTH_GT_FAIL.code, desc: String = ARR_LENGTH_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthGt)

    fun lengthGte(norm: Int, code: Long = ARR_LENGTH_GTE_FAIL.code, desc: String = ARR_LENGTH_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthGte)

    fun lengthLt(norm: Int, code: Long = ARR_LENGTH_LT_FAIL.code, desc: String = ARR_LENGTH_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthLt)

    fun lengthLte(norm: Int, code: Long = ARR_LENGTH_LTE_FAIL.code, desc: String = ARR_LENGTH_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthLte)

    fun notContainsNull(code: Long = ARR_NOT_CONTAINS_NULL_FAIL.code, desc: String = ARR_NOT_CONTAINS_NULL_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotContainsNull)

    fun notContainsDup(code: Long = ARR_NOT_CONTAINS_DUP_FAIL.code, desc: String = ARR_NOT_CONTAINS_DUP_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotContainsDup)
}


