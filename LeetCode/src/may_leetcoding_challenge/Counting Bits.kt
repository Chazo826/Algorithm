package may_leetcoding_challenge

fun main() {
    CountingBits().apply {
        println(countBits(4).fold("") { before, target -> "$before,$target" })
    }
}

class CountingBits {
    fun countBits(num: Int): IntArray {
        val bitCounts = mutableListOf<Int>(0, 1, 1, 2, 1)
        var powerOfTwo = 4
        if(num <= powerOfTwo) return bitCounts.subList(0, num + 1).toIntArray()
        for(i in 5..num) {
            if(i == (i.and(-i))) {
                bitCounts.add(1)
                powerOfTwo = i
            } else {
                val remain = i - powerOfTwo
                bitCounts.add(bitCounts[remain] + 1)
            }
        }
        return bitCounts.toIntArray()
    }
}
 /*
 0      0       0
 1      1       1
 2      1       10
 3      2       11
 4      1       100
 5      2       101
 6      2       110
 7      3       111
 8      1       1000
 9      2       1001
 10     2       1010
 11     3       1011
 12     2       1100
 13     3       1101
 14     3       1110
 15     4       1111
 16     1       10000
  */