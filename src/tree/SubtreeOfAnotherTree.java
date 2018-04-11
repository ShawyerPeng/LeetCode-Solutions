package tree;

import template.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/subtree-of-another-tree
 * 问题：判断t是否和s的某个子树完全相同
 * 思路：先从 s 的根结点开始，跟 t 比较，如果两棵树完全相同，那么返回 true
 * 否则就分别对 s 的左子结点和右子结点调用递归再次来判断是否相同，只要有一个返回 true 了，就表示可以找得到。
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        // 先从s的根结点开始，跟t比较，如果两棵树完全相同，那么返回true
        if (isSameTree(s, t)) return true;
        // 否则就分别对s的左子结点和右子结点调用递归再次来判断是否相同，只要有一个返回true了，就表示可以找得到
        return isSameTree(s.left, t) || isSameTree(s.right, t);
        // 上面的不能Accept，下面一行可以解决所有test case
        //return s != null && (isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        // 左右子树都完全相同，两棵树才完全相等
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    /**
     * 迭代遍历方法
     */
    public boolean isSubtreeIterative(TreeNode s, TreeNode t) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.offer(s);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (isSameTree(node, t)) return true;
            if (node.left != null) nodes.offer(node.left);
            if (node.right != null) nodes.offer(node.right);
        }
        return false;
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree obj = new SubtreeOfAnotherTree();
        TreeNode s = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode t = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(obj.isSubtree(s, t));
    }
}
// http://www.cnblogs.com/grandyang/p/6828687.html
// https://segmentfault.com/a/1190000009409199