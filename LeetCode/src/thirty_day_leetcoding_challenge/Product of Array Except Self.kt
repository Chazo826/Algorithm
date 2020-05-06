package thirty_day_leetcoding_challenge

private fun productExceptSelf(nums: IntArray): IntArray {
    val left = IntArray(nums.size)
    left[0] = 1
    for(i in 1 until nums.size) {
        left[i] = nums[i - 1] * left[i - 1]
    }
    val right = IntArray(nums.size)
    right[nums.size - 1] = 1
    for(i in (nums.size - 2) downTo 0) {
        right[i] = nums[i + 1] * right[i + 1]
    }

    return left.mapIndexed { index, i -> i * right[index] }.toIntArray()
}
