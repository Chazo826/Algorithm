fun main() {
//    println(singleNumber(intArrayOf(2, 2, 3, 2)))
    println(3 xor 11 xor 32 xor 77 xor 24 or 10)
}


private fun singleNumber(nums: IntArray): Int {
    if(nums.size == 1) return nums[0]
    var threeTimesXorValues = 0
    val xorValues =  nums.fold(0) { before, item ->
        if(before xor item == before - item) {
            threeTimesXorValues = threeTimesXorValues xor item
        }
        before xor item
    }
    return xorValues xor threeTimesXorValues
}