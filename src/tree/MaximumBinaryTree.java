package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/maximum-binary-tree
 * 问题：创建一个最大二叉树，创建规则是数组中的最大值为根结点，然后分隔出的左右部分再分别创建最大二叉树
 * 思路：
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        if (left == right) return null;
        int maxIndex = findMax(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, left, maxIndex);
        root.right = helper(nums, maxIndex + 1, right);
        return root;
    }

    private int findMax(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        MaximumBinaryTree obj = new MaximumBinaryTree();
        System.out.println(obj.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}).left.val);
    }
}
