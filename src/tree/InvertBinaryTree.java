package tree;

import template.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/invert-binary-tree
 * 问题：
 * 思路：
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        // 将当前节点的左右分支进行对调反转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 若左分支存在，则递归左分支的节点
        if (root.left != null) invertTree(root.left);
        // 若右分支存在，则递归右分支的节点
        if (root.right != null) invertTree(root.right);
        // 所有的节点遍历完成后，返回根节点
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree2(tmp);
        return root;
    }

    /**
     * 先序遍历非递归
     */
    public TreeNode invertTreeStack(TreeNode root) {
        if (root == null) return root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.empty()) {
            cur = stack.peek();
            stack.pop();
            // 1. 注意这里先处理cur, 即visit(cur)的所有应该做的处理
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.left = right;
            cur.right = left;
            // 2. cur遍历过了, 压入两个子树
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree obj = new InvertBinaryTree();
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(obj.invertTree(root).left.left.val);
        root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(obj.invertTree2(root).left.left.val);
        root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(obj.invertTreeStack(root).left.left.val);
    }
}
// https://www.xiabingbao.com/algorithm/2015/06/17/invert-binary-tree.html
// http://www.cnblogs.com/grandyang/p/4572877.html
// http://blog.csdn.net/einsteinzhao/article/details/77112596