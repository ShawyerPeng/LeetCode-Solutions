package depth_first_search;

import template.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum
 * 问题：求二叉树的最大路径和（可以是任意两个节点）
 * 思路：
 */
public class BinaryTreeMaximumPathSum {
    private int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        int sum = left + right + root.val;
        result = Math.max(sum, result);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(obj.maxPathSum(root));
    }
}
