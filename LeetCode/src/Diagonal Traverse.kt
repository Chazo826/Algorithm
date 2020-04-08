import kotlin.math.max

fun main() {
    println(findDiagonalOrder(arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )).toList())
}

private fun findDiagonalOrder(matrix: Array<IntArray>): IntArray {
    if(matrix.isEmpty()) return intArrayOf()

    var isUp = true
    var n = 0
    var m = 0
    var index = 0
    val array = IntArray(matrix.size * matrix[0].size)
    for (x in matrix.indices) {
        for (y in matrix[x].indices) {
            array[index++] = matrix[m][n]
            if(isUp) {
                n++
                m--
            } else {
                n--
                m++
            }
            var flag = false
            when {
                n >= matrix[x].size -> {
                    n = matrix[x].size - 1
                    m += 2
                    flag = true
                }
                m >= matrix.size -> {
                    m = matrix.size - 1
                    n += 2
                    flag = true
                }
            }
            when {
                n < 0 -> {
                    n = 0
                    flag = true
                }
                m < 0 -> {
                    m = 0
                    flag = true
                }
            }
            if(flag) isUp = !isUp
        }
    }
    return array
}