package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/validate-binary-search-tree
 * 问题：
 * 思路：
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        List<Integer> results = new ArrayList<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            results.add(node.val);
            node = node.right;
        }
        for (int i = 1; i < results.size(); i++) {
            if (results.get(i) <= results.get(i - 1)) return false;
        }
        return true;
    }

    public boolean isValidBSTDFS(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode root, int left, int right) {
        if (root == null) return true;
        return root.val > left && root.val < right
                && helper(root.left, left, root.val)
                && helper(root.right, root.val, right);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree obj = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(obj.isValidBST(root));
        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(obj.isValidBST(root));
        root = new TreeNode(1, new TreeNode(1), null);
        System.out.println(obj.isValidBST(root));
    }
}
// http://wdxtub.com/interview/14520607221359.html