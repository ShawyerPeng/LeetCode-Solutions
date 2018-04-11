package tree;

import template.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/same-tree
 * 问题：判断两棵二叉树是否完全相同
 * 思路：
 */
public class SameTree {
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;
        // 左右子树都完全相同，两棵树才完全相等
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    /**
     * DFS 前序遍历的递归写法
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) return false;

        if (p.val == q.val) {
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left && right;
        }
        return false;
    }

    /**
     * DFS 前序遍历的迭代写法，相当于同时遍历两个数，然后每个节点都进行比较。其他几种遍历顺序的迭代写法应该也能实现。
     */
    public boolean isSameTreeStack(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null && q != null) || (p != null && q == null) || (p.val != q.val)) return false;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (p != null) stack1.push(p);
        if (q != null) stack2.push(q);
        while (!stack1.empty() && !stack2.empty()) {
            TreeNode node1 = stack1.peek();
            stack1.pop();
            TreeNode node2 = stack2.peek();
            stack2.pop();
            if (node1.val != node2.val) return false;
            if (node1.left != null) stack1.push(node1.left);
            if (node2.left != null) stack2.push(node2.left);
            if (stack1.size() != stack2.size()) return false;
            if (node1.right != null) stack1.push(node1.right);
            if (node2.right != null) stack2.push(node2.right);
            if (stack1.size() != stack2.size()) return false;
        }
        return stack1.size() == stack2.size();
    }

    public static void main(String[] args) {
        SameTree obj = new SameTree();
        System.out.println(obj.isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(obj.isSameTree(new TreeNode(1, new TreeNode(2), null),
                new TreeNode(1, null, new TreeNode(2))));
        System.out.println(obj.isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                new TreeNode(1, new TreeNode(1), new TreeNode(2))));

        System.out.println(obj.isSameTreeStack(new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(obj.isSameTreeStack(new TreeNode(1, new TreeNode(2), null),
                new TreeNode(1, null, new TreeNode(2))));
        System.out.println(obj.isSameTreeStack(new TreeNode(1, new TreeNode(2), new TreeNode(1)),
                new TreeNode(1, new TreeNode(1), new TreeNode(2))));
    }
}
// http://www.cnblogs.com/grandyang/p/4053384.html