fun main() {
    println(countElements(intArrayOf(1,1,2)))
}

private fun countElements(arr: IntArray): Int {
    val map = mutableMapOf<Int, Int>()

    arr.forEach {
        map[it] = (map[it] ?: 0) + 1
    }

    var result = 0

    map.keys.forEach {
        if(map.containsKey(it + 1)) {
            result += map[it] ?: 0
        }
    }
    return result
}