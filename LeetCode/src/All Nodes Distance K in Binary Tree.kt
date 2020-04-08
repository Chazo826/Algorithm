/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

private class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

private val answer = mutableListOf<Int>()

private fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
    target ?: return listOf()
    answer.clear()
    distanceK(root, target.`val`, K)
    return answer
}

private fun distanceK(root: TreeNode?, targetValue: Int, K: Int): Int {
    root ?: return -1
    if (root.`val` == targetValue) {
        answer.addAll(findByChild(root, K))
        return K - 1
    }

    val left = distanceK(root.left, targetValue, K)
    when {
        left > 0 -> {
            answer.addAll(findByChild(root.right, left - 1))
            return left - 1
        }
        left == 0 -> {
            answer.add(root.`val`)
            return -1
        }
    }

    val right = distanceK(root.right, targetValue, K)
    when {
        right > 0 -> {
            answer.addAll(findByChild(root.left, right - 1))
            return right - 1
        }
        right == 0 -> {
            answer.add(root.`val`)
            return -1
        }
    }

    return -1
}

private fun findByChild(node: TreeNode?, K: Int): List<Int> {
    return when {
        node == null || K < 0 -> listOf()
        K == 0 -> listOf(node.`val`)
        else -> findByChild(node.left, K - 1) + findByChild(node.right, K - 1)
    }
}