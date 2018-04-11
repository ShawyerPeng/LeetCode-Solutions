package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal
 * 问题：二叉树前序遍历
 * 思路：用一个栈来实现，由于遍历过程中要先访问树的左子树，而后右子树，所以实现的时候先把根节点的右孩子入栈，而后是左孩子。
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            // 先压右后压左，这样pop遍历时的顺序就是先左后右
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return results;
    }

    public static void main(String[] args) {
        BinaryTreePreorderTraversal obj = new BinaryTreePreorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(obj.preorderTraversal(root));
    }
}
