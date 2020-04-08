import kotlin.math.min

fun main() {
    println(minimumTotal(listOf(listOf(2), listOf(3, 4), listOf(6, 5, 7), listOf(4, 1, 8, 3))))
}


private fun minimumTotal(triangle: List<List<Int>>): Int {
    val dynamicArray = Array<Array<Long>>(triangle.size) { emptyArray() }

    for(i in triangle.indices) {
        dynamicArray[i] = Array<Long>(triangle[i].size) { 0 }
        for(j in triangle[i].indices) {
            val left: Long? = try { dynamicArray[i - 1][j - 1] } catch (e: IndexOutOfBoundsException) { null }
            val right: Long? = try { dynamicArray[i -1][j] } catch (e: IndexOutOfBoundsException) { null }
            dynamicArray[i][j] = triangle[i][j].let {
                when {
                    left == null && right == null -> it.toLong()
                    left == null || right == null -> it + (right ?: 0) + (left ?: 0)
                    else -> min(left + it, right + it)
                }
            }
        }
    }
    return dynamicArray.last().min()?.toInt() ?: -1
}