package depth_first_search;

import template.TreeNode;

/**
 * https://leetcode.com/problems/path-sum
 * 问题：判断是否存在一条从根节点到叶子结点的路径使得和为sum
 * 思路：
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(0, sum, root);
    }

    private boolean dfs(int sum, int target, TreeNode root) {
        boolean left = false, right = false;
        sum += root.val;
        if (sum == target && root.left == null && root.right == null) return true;

        if (root.left != null) left = dfs(sum, target, root.left);
        if (root.right != null) right = dfs(sum, target, root.right);

        return left || right;
    }

    public static void main(String[] args) {
        PathSum obj = new PathSum();
        System.out.println(obj.hasPathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22));
        System.out.println(obj.hasPathSum(new TreeNode(1), 1));
        System.out.println(obj.hasPathSum(new TreeNode(-2, null, new TreeNode(-3)), -5));

    }
}
