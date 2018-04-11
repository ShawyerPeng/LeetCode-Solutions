package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/balanced-binary-tree
 */
public class BalancedBinaryTree {
    /**
     * O(n)
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return depth(root) != -1;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        // 在求深度的同时判断左右子树是否平衡
        // 如果左子树或右子树不平衡，或者最大深度差大于1，则返回-1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    /**
     * O(nlogn)
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        int left = depth2(root.left);
        int right = depth2(root.right);
        return Math.abs(left - right) > 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }

    public int depth2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth2(root.left), depth2(root.right)) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree obj = new BalancedBinaryTree();
    }
}