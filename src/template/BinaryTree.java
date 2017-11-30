package template;

import java.util.*;

public class BinaryTree {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;

        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;

        TreeNode prev = null; // previously traversed node
        TreeNode cur = root;

        stack.push(root);
        while (!stack.empty()) {
            cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) { // traverse down the tree
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (cur.left == prev) { // traverse up the tree from the left
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else { // traverse up the tree from the right
                result.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return result;
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List result = new ArrayList();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
