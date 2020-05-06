package thirty_day_leetcoding_challenge

import kotlin.math.max

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

fun main() {
    DiameterOfBinaryTree().apply {
        println(diameterOfBinaryTree(
            DiameterOfBinaryTree.TreeNode(1).apply {
                left = DiameterOfBinaryTree.TreeNode(2).apply {
                    left = DiameterOfBinaryTree.TreeNode(4)
                    right = DiameterOfBinaryTree.TreeNode(5)
                }
                right = DiameterOfBinaryTree.TreeNode(3)
            }
        ))
    }
}

private class DiameterOfBinaryTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    data class Length(
        val maxDeep: Int,
        val longestPath: Int
    )

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return maxLength(root, Length(0, 0)).longestPath
    }

    fun maxLength(node: TreeNode?, length: Length): Length {
        if (node == null) return length.copy(maxDeep = length.maxDeep - 1)
        println("Node val = ${node.`val`}")

        val left = maxLength(node.left, length.copy(maxDeep = length.maxDeep + 1))
        val right = maxLength(node.right, length.copy(maxDeep = length.maxDeep + 1))

        return Length(
            max(
                left.maxDeep,
                right.maxDeep
            ), max(left.maxDeep + right.maxDeep - length.maxDeep * 2, max(left.longestPath, right.longestPath))
        )
    }
}


