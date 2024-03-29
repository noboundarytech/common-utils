package tech.noboundary.common.utils

/**
 * @author: liurenpeng
 * @date: Created in 18-7-12
 */
object NumberUtil {

    // Byte

    fun isEq(target: Byte?, norm: Byte) = target == norm
    fun isGt(target: Byte?, norm: Byte) =
            if (null == target) false else target > norm

    fun isGte(target: Byte?, norm: Byte) =
            if (null == target) false else target >= norm

    fun isLt(target: Byte?, norm: Byte) =
            if (null == target) false else target < norm

    fun isLte(target: Byte?, norm: Byte) =
            if (null == target) false else target <= norm

    // Short

    fun isEq(target: Short?, norm: Short) = target == norm
    fun isGt(target: Short?, norm: Short) =
            if (null == target) false else target > norm

    fun isGte(target: Short?, norm: Short) =
            if (null == target) false else target >= norm

    fun isLt(target: Short?, norm: Short) =
            if (null == target) false else target < norm

    fun isLte(target: Short?, norm: Short) =
            if (null == target) false else target <= norm

    // Int

    fun isEq(target: Int?, norm: Int) = target == norm
    fun isGt(target: Int?, norm: Int) =
            if (null == target) false else target > norm

    fun isGte(target: Int?, norm: Int) =
            if (null == target) false else target >= norm

    fun isLt(target: Int?, norm: Int) =
            if (null == target) false else target < norm

    fun isLte(target: Int?, norm: Int) =
            if (null == target) false else target <= norm

    // Long

    fun isEq(target: Long?, norm: Long) = target == norm
    fun isGt(target: Long?, norm: Long) =
            if (null == target) false else target > norm

    fun isGte(target: Long?, norm: Long) =
            if (null == target) false else target >= norm

    fun isLt(target: Long?, norm: Long) =
            if (null == target) false else target < norm

    fun isLte(target: Long?, norm: Long) =
            if (null == target) false else target <= norm

    // Float

    fun isEq(target: Float?, norm: Float) = target == norm
    fun isGt(target: Float?, norm: Float) =
            if (null == target) false else target > norm

    fun isGte(target: Float?, norm: Float) =
            if (null == target) false else target >= norm

    fun isLt(target: Float?, norm: Float) =
            if (null == target) false else target < norm

    fun isLte(target: Float?, norm: Float) =
            if (null == target) false else target <= norm

    // Double

    fun isEq(target: Double?, norm: Double) = target == norm
    fun isGt(target: Double?, norm: Double) =
            if (null == target) false else target > norm

    fun isGte(target: Double?, norm: Double) =
            if (null == target) false else target >= norm

    fun isLt(target: Double?, norm: Double) =
            if (null == target) false else target < norm

    fun isLte(target: Double?, norm: Double) =
            if (null == target) false else target <= norm
}