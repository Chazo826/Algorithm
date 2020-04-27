import kotlin.math.max

fun main() {
    println(ContiguousArray().findMaxLength(intArrayOf(0, 1, 0, 0, 1, 1, 0)))
}

class ContiguousArray {

    fun findMaxLength(nums: IntArray): Int {
        val map = HashMap<Int, Int>().apply {
            put(0, -1)
        }
        var max = 0
        var value = 0

        nums.forEachIndexed { index, i ->
            value += if(i == 1) 1 else -1
            map[value]?.let {
                max = max(max, index - it)
            } ?: kotlin.run {
                map[value] = index
            }
        }

        return max
    }

//    fun findMaxLength(nums: IntArray): Int {
//        var max = 0
//        var zeroCount = 0
//        var oneCount = 0
//
//        nums.forEach {
//            when(it) {
//                0 -> zeroCount++
//                1 -> oneCount++
//            }
//            if(zeroCount == oneCount) max = zeroCount * 2
//        }
//
//        for(i in 0 until nums.size / 2) {
//            when(nums[i]) {
//                0 -> zeroCount--
//                1 -> oneCount--
//            }
//
//        }
//
//        for(i in nums.indices) {
//            for(j in i until nums.size) {
//                when(nums[j]) {
//                    0 -> zeroCount++
//                    1 -> oneCount++
//                }
//                if(zeroCount == oneCount) max = max(max, zeroCount * 2)
//            }
//            zeroCount = 0
//            oneCount = 0
//        }
//
//        return max
//    }
}