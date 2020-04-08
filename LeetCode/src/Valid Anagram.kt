fun main() {
    println(isAnagram2("aa", "a"))
    println(isAnagram2("anagram", "nagaram"))
}

private fun isAnagram(s: String, t: String): Boolean {
    return createMap(s) == createMap(t)
}

private fun createMap(s: String): Map<Char, Int> {
    return HashMap<Char, Int>().apply {
        s.forEach {
            this[it] =  (this[it] ?: 0) + 1
        }
    }
}

private fun isAnagram2(s: String, t: String): Boolean {
    val map = CharArray(52)

    s.forEach { map[it - 'a']++ }
    t.forEach { map[it - 'a']-- }

    map.forEach {
        if(it.toInt() != 0) return false
    }

    return true
}