fun main() {
    println(isHappy(1111111))
}

private fun isHappy(n: Int): Boolean {
    val sums = HashSet<Int>()
    var sum = n
    while (sum != 1) {
        if (sums.contains(sum)) return false
        sums.add(sum)
        sum = sumACipherSquare(sum)
    }
    return true
}

private fun sumACipherSquare(n: Int): Int {
    var temp = n
    var result = 0
    while (temp != 0) {
        val num = temp % 10
        result += num * num
        temp /= 10
    }
    return result
}