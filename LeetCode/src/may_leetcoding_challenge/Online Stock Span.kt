package may_leetcoding_challenge

fun main() {
    OnlineStockSpan().apply {
        next(100)
        next(80)
        next(60)
        next(70)
        next(60)
        next(75)
        next(85)
    }
}

class OnlineStockSpan {
    private val stocks = mutableListOf<Int>()

    fun next(price: Int): Int {
        stocks.add(price)

        var count = 0
        for(i in stocks.indices.reversed()) {
            val item = stocks[i]

            if(item <= price) {
                count++
            } else {
                return count
            }
        }
        return count
    }
}