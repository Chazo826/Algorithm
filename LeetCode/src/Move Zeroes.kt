fun main() {
    val nums = intArrayOf(0,1,0,3,12)
    moveZeroes(nums)
    println(nums.toList())
}


private fun moveZeroes(nums: IntArray): Unit {
    var index = 0
    var size = nums.size
    while(index < size) {
        if(nums[index] == 0) {
            var x = index
            while (x < size - 1) {
                nums[x] = nums[x+1]
                x++
            }
            nums[x] = 0
            size--
        } else {
            index++
        }
    }
}