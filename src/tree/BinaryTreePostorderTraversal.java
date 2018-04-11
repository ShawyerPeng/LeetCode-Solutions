package tree;

import template.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal
 * 问题：二叉树后序遍历
 * 思路：
 */
public class BinaryTreePostorderTraversal {
    /**
     * 通过一个栈来和一个访问前驱标志来实现，通过这个标志为来判断根节点的右子树是否访问完，如果访问完则访问根节点，否则继续遍历右子树
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        // 访问前驱标志
        TreeNode prev = null;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            node = stack.peek();
            if (prev == null || prev.left == node || prev.right == node) {
                // traverse down the tree
                if (node.left != null) {
                    // 找到最左孩子
                    stack.push(node.left);
                } else if (node.right != null) {
                    // 如果右子树没有被访问，访问右子树
                    stack.push(node.right);
                }
            } else if (node.left == prev) {
                // traverse up the tree from the left
                if (node.right != null) {
                    stack.push(node.right);
                }
            } else {
                // traverse up the tree from the right
                // 访问根节点
                results.add(node.val);
                stack.pop();
            }
            prev = node;
        }
        return results;
    }

    /**
     * 只通过一个栈来实现
     */
    public List<Integer> postorderTraversalDeque(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    /**
     * 通过两个栈来实现
     */
    public List<Integer> postorderTraversalTwoStack(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.empty()) {
            TreeNode node = s1.pop();
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
            s2.push(node);
        }
        while (!s2.empty()) {
            results.add(s2.pop().val);
        }
        return results;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> results = new LinkedList<>();
        if (root == null) return results;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.addFirst(node.val);
            if (node.left!=null) stack.push(node.left);
            if (node.right!=null) stack.push(node.right);
        }
        return results;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal obj = new BinaryTreePostorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(obj.postorderTraversal(root));
        System.out.println(obj.postorderTraversalDeque(root));
        System.out.println(obj.postorderTraversalTwoStack(root));
    }
}
