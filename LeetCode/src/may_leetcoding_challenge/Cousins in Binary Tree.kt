package may_leetcoding_challenge

fun main() {

}

class CousinsInBinaryTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        if(root?.`val` == x || root?.`val` == y) return false

        val xTreeNodeInfo = searchTree(root, x, 0)
        val yTreeNodeInfo = searchTree(root, y, 0)

        return if(xTreeNodeInfo?.deep == yTreeNodeInfo?.deep) {
            xTreeNodeInfo?.parent != yTreeNodeInfo?.parent
        } else {
            false
        }
    }

    private fun searchTree(node: TreeNode?, target: Int, deep: Int): TargetNodeInfo? {
        if(node == null) return null

        return when(target) {
            node.left?.`val` -> TargetNodeInfo(node, deep + 1, node.left!!)
            node.right?.`val` -> TargetNodeInfo(node, deep + 1, node.right!!)
            else -> {
                searchTree(node.left, target, deep + 1)
                    ?: searchTree(node.right, target, deep + 1)
            }
        }
    }

    private data class TargetNodeInfo(
        val parent: TreeNode,
        val deep: Int,
        val target: TreeNode
    )
}



