fun main() {
    println(twoSum(intArrayOf(3, 2, 4), 6).toList())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { index, i ->
        map[i] = index
    }

    nums.forEachIndexed { index, i ->
        map[target - i]?.let {
            if(it != index) {
                return intArrayOf(index, it)
            }
        }
    }

    return intArrayOf()
}