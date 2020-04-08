import java.lang.IndexOutOfBoundsException
import java.lang.Math.max

fun main() {
    print(longestIncreasingPath(arrayOf(intArrayOf(9, 9, 4), intArrayOf(6, 6, 8), intArrayOf(2, 1, 1))))
}


private fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty()) return 0

    var max = 0

    val memoization = Array<IntArray>(matrix.size) { IntArray(matrix[0].size) }
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            max = max(max, findPath(matrix, i, j, memoization, -1))
        }
    }

    return (memoization.map { it.max() }.maxBy { it ?: 1 } ?: 1).let { if (it == 0) 1 else it }
}

private fun findPath(matrix: Array<IntArray>, i: Int, j: Int, memoization: Array<IntArray>, beforeValue: Int): Int {
    if (matrix[i][j] <= beforeValue) return 0
    if (memoization[i][j] != 0) return memoization[i][j]

    val top = try {
        findPath(matrix, i - 1, j, memoization, matrix[i][j])
    } catch (e: IndexOutOfBoundsException) {
        0
    }
    val left = try {
        findPath(matrix, i, j - 1, memoization, matrix[i][j])
    } catch (e: IndexOutOfBoundsException) {
        0
    }
    val bottom = try {
        findPath(matrix, i + 1, j, memoization, matrix[i][j])
    } catch (e: IndexOutOfBoundsException) {
        0
    }
    val right = try {
        findPath(matrix, i, j + 1, memoization, matrix[i][j])
    } catch (e: IndexOutOfBoundsException) {
        0
    }

    memoization[i][j] = intArrayOf(top, left, bottom, right).max()!! + 1
    return memoization[i][j]
}