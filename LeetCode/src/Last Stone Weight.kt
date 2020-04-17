import java.util.*

fun main() {
    LastStoneWeight().apply {
        println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
    }
}

class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int>(kotlin.Comparator { o1, o2 ->
            when {
                o1 > o2 -> -1
                o1 < o2 -> 1
                else -> 0
            }
        })

        queue.addAll(stones.asIterable())

        while (queue.size > 1) {
            val heaviest = queue.remove()
            val other = queue.remove()

            (heaviest - other).let {
                if(it != 0){
                    queue.add(it)
                }
            }
        }

        return if(queue.size == 0) 0 else queue.remove()
    }
}