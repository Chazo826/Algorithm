fun main() {

    println(numberOfSubstrings("aaaabc"))
}

private fun numberOfSubstrings(s: String): Int {
    var resultCount = 0
    var lastEndIndex = 3
    for(startIndex in 0..(s.length - 3)) {
        if(lastEndIndex - startIndex < 3) lastEndIndex++
        for(endIndex in (lastEndIndex)..(s.length)) {
            if(s.substring(startIndex, endIndex).run { contains('a').and(contains('b')).and(contains('c')) }) {
                resultCount += 1 + s.length - endIndex
                lastEndIndex = endIndex
                break
            }
        }
    }
    return resultCount
}