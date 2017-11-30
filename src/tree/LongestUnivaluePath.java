package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/longest-univalue-path
 * 问题：最长相同值路径
 * 思路：
 */
public class LongestUnivaluePath {
    private int maxLen;

    public int longestUnivaluePath(TreeNode node) {
        if (node == null) return 0;
        dfs(node);
        return maxLen;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);
        left = (node.left != null && node.val == node.left.val) ? left + 1 : 0;
        right = (node.right != null && node.val == node.right.val) ? right + 1 : 0;
        maxLen = Math.max(maxLen, left + right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        LongestUnivaluePath obj = new LongestUnivaluePath();
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)), new TreeNode(5, null, new TreeNode(5)));
        System.out.println(obj.longestUnivaluePath(root));
    }
}
// http://www.cnblogs.com/grandyang/p/7636259.html