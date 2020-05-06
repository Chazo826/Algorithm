package thirty_day_leetcoding_challenge

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */


private class MiddleOfTheLinkedList {
    private class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun middleNode(head: ListNode?): ListNode? {
        var size = 0

        val list = mutableListOf<ListNode>()

        if(head?.next == null) return head

        var node = head
        while(node != null) {
            list.add(node)
            node = node.next
            size++
        }

        return list[size / 2]
    }
}