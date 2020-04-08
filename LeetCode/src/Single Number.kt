fun main() {
    println(singleNumber(intArrayOf(4, 1, 2, 1, 2, 1, 2)))
}


private fun singleNumber(nums: IntArray): Int {
    if(nums.size == 1) return nums[0]
    return nums.fold(0) { before, item -> before xor item }
}