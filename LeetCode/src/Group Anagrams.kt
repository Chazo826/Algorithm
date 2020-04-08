fun main() {

}

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map: MutableMap<String, List<String>> = mutableMapOf()
    strs.forEach { original ->
        String(original.toCharArray().apply { sort() }).let { sorted ->
            val array = map[sorted] ?: listOf()
            map[sorted] = array.plus(original)
        }
    }
    return map.values.toList()
}