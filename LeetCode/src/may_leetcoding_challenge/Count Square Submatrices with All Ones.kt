package may_leetcoding_challenge

import java.lang.Integer.min

class CountSquareSubmatricesWithAllOnes {

    fun countSquares(matrix: Array<IntArray>): Int {
        if(matrix.isEmpty()) return 0
        val minSide = min(matrix.size, matrix[0].size)
        var result = matrix.sumBy { it.sum() }
        var subArray = matrix
        for (i in 1..minSide) {
            subArray = createSubArray(subArray)
            result += subArray.sumBy { it.sum() }
        }
        return result
    }

    private fun createSubArray(matrix: Array<IntArray>): Array<IntArray> {
        val subArray = Array(matrix.size - 1) { IntArray(matrix[0].size - 1) }
        for(i in 0 until matrix.size - 1) {
            for(j in 0 until matrix[i].size - 1) {
                subArray[i][j] = matrix[i][j].and(matrix[i + 1][j]).and(matrix[i][j + 1]).and(matrix[i + 1][j + 1])
            }
        }
        return subArray
    }
}