package tech.noboundary.common.utils

/**
 * @author: liurenpeng
 * @date: Created in 18-7-24
 */
object CharUtil {

    fun isEq(target: Char?, norm: Char?) = norm == target
    fun isGt(target: Char?, norm: Char) =
            if (null == target) false else target > norm

    fun isGte(target: Char?, norm: Char) =
            if (null == target) false else target >= norm

    fun isLt(target: Char?, norm: Char) =
            if (null == target) false else target < norm

    fun isLte(target: Char?, norm: Char) =
            if (null == target) false else target <= norm

}