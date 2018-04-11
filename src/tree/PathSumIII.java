package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/path-sum-iii
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        // 把左右节点重新看做一个根节点
        return helper(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int sum, int target) {
        if (root == null) return 0;
        int res = 0;
        sum += root.val;
        // 这里不能直接退出，而是res++，然后遍历左右子树，最后再返回
        if (sum == target) res++;
        res += helper(root.left, sum, target) + helper(root.right, sum, target);
        return res;
    }

    public static void main(String[] args) {
        PathSumIII obj = new PathSumIII();
    }
}
