package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/longest-univalue-path
 * 问题：最长相同值路径
 * 思路：
 */
public class LongestUnivaluePath {
    private int maxLen;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return maxLen;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        // 求出左右子树的单边最长UnivaluePath
        int left = helper(root.left);
        int right = helper(root.right);
        left = (root.left != null && root.val == root.left.val) ? left + 1 : 0;
        right = (root.right != null && root.val == root.right.val) ? right + 1 : 0;
        // 可以更新双边的情况
        maxLen = Math.max(maxLen, left + right);
        // 只能返回长度较大的一边
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        LongestUnivaluePath obj = new LongestUnivaluePath();
        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)), new TreeNode(5, null, new TreeNode(5)));
        System.out.println(obj.longestUnivaluePath(root));
    }
}
// http://www.cnblogs.com/grandyang/p/7636259.html