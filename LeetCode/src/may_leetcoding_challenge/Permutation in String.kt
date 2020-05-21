package may_leetcoding_challenge

fun main() {

    println(PermutationInString().checkInclusion("hello", "ooolleoooleh"))

}

class PermutationInString {
//    fun checkInclusion(s1: String, s2: String): Boolean {
//        val wordMap: MutableMap<Char, Int> = HashMap<Char, Int>()
//
//        s1.forEach {
//            wordMap[it] = (wordMap[it] ?: 0) + 1
//        }
//
//        var count = 0
//        var tempMap: MutableMap<Char, Int> = HashMap(wordMap)
//        var index = 0
//        while(index < s2.length) {
//            val targetChar = s2[index]
//            if((tempMap[targetChar] ?: 0) > 0) {
//                if(++count == s1.length) {
//                    return true
//                } else {
//                    tempMap[targetChar] = tempMap[targetChar]!! - 1
//                }
//            } else {
//                index -= count
//                count = 0
//                tempMap = HashMap(wordMap)
//            }
//            if(s2.length - index < s1.length - count) return false
//            index++
//        }
//        return false
//    }

    //Sliding Window
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val s1map = IntArray(26)
        val s2map = IntArray(26)
        for (i in s1.indices) {
            s1map[s1[i] - 'a']++
            s2map[s2[i] - 'a']++
        }
        for (i in 0 until s2.length - s1.length) {
            if (matches(s1map, s2map)) return true
            s2map[s2[i + s1.length] - 'a']++
            s2map[s2[i] - 'a']--
        }
        return matches(s1map, s2map)
    }

    private fun matches(s1map: IntArray, s2map: IntArray): Boolean {
        for (i in 0..25) {
            if (s1map[i] != s2map[i]) return false
        }
        return true
    }
}