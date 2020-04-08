import kotlin.math.abs
import kotlin.math.min

fun main() {
    println(nearestPalindromic("10"))
}

private fun nearestPalindromic(n: String): String {
    if (n == "1") return "0"

    //그냥 앞에꺼 붙이면 몇차이나는지 체크 (자기자신 금지)
    val mirrorString = mirror(n)
    val mirrorDiff = abs(n.toLong() - mirrorString.toLong()).let { if (it == 0L) Long.MAX_VALUE else it }

    //감소
    val decreaseBuilder = StringBuilder(n)
    var index = (decreaseBuilder.length - 1) / 2
    while (index >= 0 && decreaseBuilder[index] == '0') {
        decreaseBuilder[index] = '9'
        index--
    }

    if (index == 0 && decreaseBuilder[0] == '1') {
        decreaseBuilder.delete(0, 1)
        decreaseBuilder[(decreaseBuilder.length - 1) / 2] = '9'
    } else {
        decreaseBuilder[index] = decreaseBuilder[index] - 1
    }
    val decreaseMirrorString = mirror(decreaseBuilder.toString())
    val decreaseMirrorDiff = abs(n.toLong() - decreaseMirrorString.toLong())

    //증가
    val increaseBuilder = StringBuilder(n)
    index = (increaseBuilder.length - 1) / 2
    while (index >= 0 && increaseBuilder[index] == '9') {
        increaseBuilder[index] = '0'
        index--
    }

    if (index < 0) {
        increaseBuilder.insert(0, "1")
    } else {
        increaseBuilder[index] = increaseBuilder[index] + 1
    }
    val increaseMirrorString = mirror(increaseBuilder.toString())
    val increaseMirrorDiff = abs(n.toLong() - increaseMirrorString.toLong())

    return when(min(mirrorDiff, min(decreaseMirrorDiff, increaseMirrorDiff))) {
        decreaseMirrorDiff -> decreaseMirrorString
        mirrorDiff -> mirrorString
        else -> increaseMirrorString
    }
}

private fun mirror(n: String): String {
    return n.substring(0, n.length / 2).let {it + (if (n.length % 2 == 0) "" else n[n.length / 2]) + it.reversed()}
}