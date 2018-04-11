package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree
 * 问题：给定一颗二叉树，寻找这棵树的直径，直径定义为这棵树中任意两个节点的路径长度最大值。注意：最长路径可能不经过根节点。
 * 思路：面对树结构，常理采用 recursion。 判断 左边 + 右边 是否最长，回溯则选择最长的一边。
 * 1. 最长路径经过根节点：那么根节点的左子树的深度和右子树的深度就是我们的结果
 * 2. 最长路径没有经过根节点：这个问题就分为两个子问题，分别设置新的根节点为其左子节点和右子节点，然后重复步骤 1
 */
public class DiameterOfBinaryTree {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 空节点或者左右孩子均为空的节点
        if (root == null || (root.left == null && root.right == null)) return 0;
        helper(root);
        return diameter;
    }

    // 此函数返回树的最大深度
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        // 左子树和右子树的深度相加就是根该节点的直径
        diameter = Math.max(diameter, left + right);
        // 返回节点左右子树中较大的深度
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(obj.diameterOfBinaryTree(root));
    }
}
// http://blog.csdn.net/u012814856/article/details/76212141
// http://www.jianshu.com/p/b6da9cb48113
// http://www.cnblogs.com/grandyang/p/6607318.html