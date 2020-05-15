package may_leetcoding_challenge

class ValidPerfectSquare {
    fun isPerfectSquare(num: Int): Boolean {
        var index = 1
        while(true) {
            val square: Long = index * index.toLong()
            when {
                square == num.toLong() -> return true
                square > num -> return false
            }
            index++
        }
    }
}