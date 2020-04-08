

fun main() {
    mirrorReflection(3, 1)
}

private fun mirrorReflection(p: Int, q: Int): Int {
    var side = p
    var height = q
    while(side % 2 == 0 && height % 2 == 0) {
        side /= 2
        height /= 2
    }
    
    return when {
        side % 2 == 0 && height % 2 == 1 -> 2
        else -> if(height % 2 == 1) 1 else 0
    }
}