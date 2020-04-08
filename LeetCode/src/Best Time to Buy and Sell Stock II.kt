fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}

private fun maxProfit(prices: IntArray): Int {
    var totalProfit = 0
    var value = -1
    prices.forEachIndexed { index, i ->
        if(value == -1 && isProfit(index, prices)) {
            value = i
        } else if(value != -1) {
            val nextPrice = try {
                prices[index + 1]
            } catch (e: IndexOutOfBoundsException) {
                -1
            }
            if(value < i && i > nextPrice) {
                totalProfit += i - value
                value = -1
            }
        }
    }
    return totalProfit
}

private fun isProfit(index: Int, prices: IntArray): Boolean {
    return prices[index] < try {
        prices[index + 1]
    } catch (e: IndexOutOfBoundsException) {
        -1
    }
}