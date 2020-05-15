package may_leetcoding_challenge

private class Trie() {

    /** Initialize your data structure here. */
    data class Node(
        val value: Char? = null
    ) {
        val nodeMap = HashMap<Char?, Node>()
    }

    private val root = Node(null)


    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var node = root
        word.forEach {
            node.nodeMap[it]?.let {
                node = it
            } ?: kotlin.run {
                Node(it).apply {
                    node.nodeMap[it] = this
                    node = this
                }
            }
        }
        node.nodeMap['0'] = Node(null)
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var node = root
        word.forEach {
            node.nodeMap[it]?.let {
                node = it
            } ?: return false
        }
        return node.nodeMap.contains('0')
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var node = root
        prefix.forEach {
            node.nodeMap[it]?.let {
                node = it
            } ?: return false
        }
        return true
    }
}