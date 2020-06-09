package june_leetcoding_challenge

fun main() {
    println(CoinChange2().change(5, intArrayOf(1, 2, 5)))
}

class CoinChange2 {
    /***
     * 5, [1,2,5]
     * 1x + 2y + 5z = 5
     *
     * 6,
     * 5+1, 2+2+2,
     *
     * 7
     * 5 -> 2, 1+1
     * 2 -> 2+2+2+1
     * 1 -> 0
     */

    fun change(amount: Int, coins: IntArray): Int {
        val dynamic = IntArray(amount + 1)
        val min = coins.min() ?: 0
        dynamic[0] = 1
        for(i in coins.indices) {
            for(j in coins[i]..amount) {
                dynamic[j] = dynamic[j] + dynamic[j - coins[i]]
            }
        }
        return dynamic.last()
    }
}