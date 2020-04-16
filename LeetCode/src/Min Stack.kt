import java.util.*

class MinStack() {

    /** initialize your data structure here. */
    private val stack = Stack<Int>()
    private val sortedQueue = PriorityQueue<Int>()


    fun push(x: Int) {
        stack.push(x)
        sortedQueue.add(x)
    }

    fun pop() {
        sortedQueue.remove(stack.pop())
    }

    fun top(): Int = stack.peek()

    fun getMin(): Int {
        return sortedQueue.peek()
    }
}

fun main() {
    val minStack = MinStack()
    minStack.apply {
        push(-2)
        push(0)
        push(-1)
        println(getMin())
        println(top())
        println(pop())
        println(getMin())
    }
}