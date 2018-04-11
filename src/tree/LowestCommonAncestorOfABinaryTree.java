package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 叶子节点左右孩子都为空，这时候返回null
        if (root == null) return null;
        // 发现目标节点则通过返回值标记该子树发现了某个目标结点
        if (root == p || root == q) return root;
        // Divide
        // 查看左子树中是否有目标结点，没有为null
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 查看右子树是否有目标节点，没有为null
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // Conquer
        // 左右节点都不为空，说明左右子树都有目标结点，则公共祖先就是本身
        if (left != null && right != null) return root;
        // 如果发现了目标节点，则继续向上标记为该目标节点
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree obj = new LowestCommonAncestorOfABinaryTree();
    }
}
