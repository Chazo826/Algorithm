package may_leetcoding_challenge

import kotlin.math.abs


fun main() {
    CheckIfItIsAStraightLine().apply {
        println(checkStraightLine(arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5),
            intArrayOf(5, 6),
            intArrayOf(6, 7)
        )))
    }
}

class CheckIfItIsAStraightLine {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val angle = getAngle(coordinates[0], coordinates[1])
        for (i in 2 until coordinates.size) {
            val newAngle = getAngle(coordinates[0], coordinates[i])
            when {
                angle != newAngle -> return false
                angle == Float.POSITIVE_INFINITY && coordinates[0][0] != coordinates[i][0] -> return false
                angle == 0f && coordinates[0][1] != coordinates[i][1] -> return false
            }
        }
        return true
    }

    fun getAngle(point1: IntArray, point2: IntArray): Float {
        val dy = point2[1] - point1[1]
        val dx = point2[0] - point1[0]
        if (dx == 0) return Float.POSITIVE_INFINITY
        return dy / dx.toFloat()
    }
}