package thirty_day_leetcoding_challenge

import java.util.*

fun main() {

}

fun backspaceCompare(S: String, T: String): Boolean {
    val charQueue = Stack<Char>()

    S.forEach {
        if(it == '#') {
            try {
                charQueue.pop()
            } catch (e: EmptyStackException) {}
        } else {
            charQueue.push(it)
        }
    }

    val afterS = charQueue.toString()
    charQueue.clear()

    T.forEach {
        if(it == '#') {
            try {
                charQueue.pop()
            } catch (e: EmptyStackException) {}
        } else {
            charQueue.push(it)
        }
    }

    val afterT = charQueue.toString()
e
    return afterS == afterT
}