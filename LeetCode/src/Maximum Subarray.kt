import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import kotlin.math.max

fun main() {
    println(maxSubArray2(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray2(intArrayOf(-2, 1)))
    println(maxSubArray2(intArrayOf(-1, 0, -2)))
}

private fun maxSubArray(nums: IntArray): Int {
    var accumulation = 0
    var maxValue = Int.MIN_VALUE

    nums.forEach {
        if (accumulation < 0) accumulation = 0
        accumulation += it

        maxValue = max(maxValue, accumulation)
    }
    return maxValue
}

private fun maxSubArray2(nums: IntArray): Int {
    if(nums.size == 1) return nums[0]
    return divide(nums)
}

private fun divide(array: IntArray): Int {
    if(array.size == 2) return max(array[0] + array[1], max(array[0], array[1]))
    var maxValue = Int.MIN_VALUE
    val subArraySize = array.size / 2 + array.size % 2
    val array1 = IntArray(subArraySize)
    val array2 = IntArray(subArraySize)

    var index = 0
    for (i in 0 until subArraySize) {
        val value = array[index] +
                try {
                    array[index + 1]
                } catch (e: Exception) {
                    0
                }
        maxValue = max(maxValue, value)
        array1[i] = value
        index += 2
    }

    index = 1
    array2[0] = array[0]
    for (i in 1 .. subArraySize) {
        if(index >= array.size) break
        val value = array[index] +
                try {
                    array[index + 1]
                } catch (e: Exception) {
                    0
                }
        maxValue = max(maxValue, value)
        array2[i] = value
        index += 2
    }

    return max(maxValue, max(divide(array1), divide(array2)))
}