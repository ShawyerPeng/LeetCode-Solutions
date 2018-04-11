package tree;

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
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        // 小于0就没有必要加入
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int sum = left + right + root.val;
        // result和返回的结果在本次循环中完全没有联系
        result = Math.max(result, sum);
        // 返回时只能返回路径和较大一边
        // root.val就算是负值也必须被使用
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(obj.maxPathSum(root));
    }
}
