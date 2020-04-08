
private fun findNthDigit(n: Int): Int {
    var value = n

    var start = 1
    var length = 1;
    var base = 9L;

    while ( value > length * base) {
        value -= (length * base).toInt()
        length++
        start *= 10
        base *= 10
    }

    val target = start + (value - 1)/length
    val index = (value - 1) % length

    return target.toString()[index] - '0'
}