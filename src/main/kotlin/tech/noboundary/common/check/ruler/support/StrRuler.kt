package tech.noboundary.common.check.ruler.support

import tech.noboundary.common.check.CheckResultCodeEnum.STR_ALL_LETTER_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_DIGIT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_EMAIL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_EMPTY_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_EQ_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_ID_CARD_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_LENGTH_EQ_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_LENGTH_GTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_LENGTH_GT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_LENGTH_LTE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_LENGTH_LT_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_NOT_EMPTY_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_NOT_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_NULL_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_PHONE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_STANDARD_DATETIME_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_STANDARD_DATE_FAIL
import tech.noboundary.common.check.CheckResultCodeEnum.STR_URL_FAIL
import tech.noboundary.common.check.and
import tech.noboundary.common.check.ruler.Ruler
import tech.noboundary.common.utils.StringUtil.isAllLetter
import tech.noboundary.common.utils.StringUtil.isDigit
import tech.noboundary.common.utils.StringUtil.isEmail
import tech.noboundary.common.utils.StringUtil.isEmpty
import tech.noboundary.common.utils.StringUtil.isEq
import tech.noboundary.common.utils.StringUtil.isIdCard
import tech.noboundary.common.utils.StringUtil.isLengthEq
import tech.noboundary.common.utils.StringUtil.isLengthGt
import tech.noboundary.common.utils.StringUtil.isLengthGte
import tech.noboundary.common.utils.StringUtil.isLengthLt
import tech.noboundary.common.utils.StringUtil.isLengthLte
import tech.noboundary.common.utils.StringUtil.isNotEmpty
import tech.noboundary.common.utils.StringUtil.isPhone
import tech.noboundary.common.utils.StringUtil.isStandardDate
import tech.noboundary.common.utils.StringUtil.isStandardDatetime
import tech.noboundary.common.utils.StringUtil.isUrl

/**
 * @author: liurenpeng
 * @date: Created in 18-7-12
 */
object StrRuler {
    val beNull = beNull()
    val notNull = notNull()
    val beEmpty = beEmpty()
    val notEmpty = notEmpty()

    val beIdCard = beIdCard()
    val beEmail = beEmail()
    val bePhone = bePhone()
    val beStandardDate = beStandardDate()
    val beStandardDatetime = beStandardDatetime()
    val beUrl = beUrl()
    val beAllLetter = beAllLetter()
    val beDigit = beDigit()

    fun beNull(code: Long = STR_NULL_FAIL.code, desc: String = STR_NULL_FAIL.desc)
            = Ruler.ofBeNull<String?>(code, desc)

    fun notNull(code: Long = STR_NOT_NULL_FAIL.code, desc: String = STR_NOT_NULL_FAIL.desc)
            = Ruler.ofNotNull<String?>(code, desc)

    fun beEmpty(code: Long = STR_EMPTY_FAIL.code, desc: String = STR_EMPTY_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isEmpty)

    fun notEmpty(code: Long = STR_NOT_EMPTY_FAIL.code, desc: String = STR_NOT_EMPTY_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isNotEmpty)

    fun lengthEq(norm: Int, code: Long = STR_LENGTH_EQ_FAIL.code, desc: String = STR_LENGTH_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthEq)

    fun lengthGt(norm: Int, code: Long = STR_LENGTH_GT_FAIL.code, desc: String = STR_LENGTH_GT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthGt)

    fun lengthGte(norm: Int, code: Long = STR_LENGTH_GTE_FAIL.code, desc: String = STR_LENGTH_GTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthGte)

    fun lengthLt(norm: Int, code: Long = STR_LENGTH_LT_FAIL.code, desc: String = STR_LENGTH_LT_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthLt)

    fun lengthLte(norm: Int, code: Long = STR_LENGTH_LTE_FAIL.code, desc: String = STR_LENGTH_LTE_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isLengthLte)

    fun eq(norm: String, code: Long = STR_EQ_FAIL.code, desc: String = STR_EQ_FAIL.desc)
            = notNull and Ruler.of(norm, code, desc, ::isEq)

    fun beIdCard(code: Long = STR_ID_CARD_FAIL.code, desc: String = STR_ID_CARD_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isIdCard)

    fun beEmail(code: Long = STR_EMAIL_FAIL.code, desc: String = STR_EMAIL_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isEmail)

    fun bePhone(code: Long = STR_PHONE_FAIL.code, desc: String = STR_PHONE_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isPhone)

    fun beStandardDate(code: Long = STR_STANDARD_DATE_FAIL.code, desc: String = STR_STANDARD_DATE_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isStandardDate)

    fun beStandardDatetime(code: Long = STR_STANDARD_DATETIME_FAIL.code, desc: String = STR_STANDARD_DATETIME_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isStandardDatetime)

    fun beUrl(code: Long = STR_URL_FAIL.code, desc: String = STR_URL_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isUrl)

    fun beAllLetter(code: Long = STR_ALL_LETTER_FAIL.code, desc: String = STR_ALL_LETTER_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isAllLetter)

    fun beDigit(code: Long = STR_DIGIT_FAIL.code, desc: String = STR_DIGIT_FAIL.desc)
            = notNull and Ruler.of(code, desc, ::isDigit)
}
