package thirty_day_leetcoding_challenge
fun main() {
    println(
        Solution().stringShift("mecsk",
        arrayOf(intArrayOf(1, 1))))
}

private class Solution {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        //음수면 왼쪽 양수면 오른쪽
        var shiftValue = 0

        shift.forEach {
            shiftValue += it[1] * when(it[0]) {
                0 -> -1
                else -> 1
            }
        }

        shiftValue %= s.length
        var result = s
        when {
            //왼쪽
            0 > shiftValue -> {
                result = s.substring(shiftValue * -1, s.length) + s.substring(0, shiftValue * -1)
            }
            //오른쪽
            0 < shiftValue -> {
                result = s.substring(s.length - shiftValue, s.length) + s.substring(0, s.length - shiftValue)
            }
        }
        return result
    }
}