package may_leetcoding_challenge

import kotlin.math.min

fun firstUniqChar(s: String): Int {
    val indexMap = HashMap<Char, Int>()
    val repeatingCountMap = HashMap<Char, Int>()

    s.forEachIndexed { index, c ->
        if(!indexMap.contains(c)){
            indexMap[c] = index
        }

        repeatingCountMap[c] = repeatingCountMap[c]?.let { it + 1 } ?: 1
    }

    val nonRepeats = repeatingCountMap.filterValues { it == 1 }.keys

    var result = Int.MAX_VALUE
    nonRepeats.forEach {
        result = min(indexMap[it]!!, result)
    }

    return if(nonRepeats.isEmpty()) -1 else result
}
