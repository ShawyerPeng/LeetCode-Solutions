package sword_for_offer;

import template.TreeNode;

/**
 * https://www.nowcoder.com/questionTerminal/ef068f602dde4d28aab2b210e859150a
 * 问题：二叉搜索树的第k个结点
 * 思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。所以，按照中序遍历顺序找到第k个结点就是结果。
 */
public class No63 {
    int index = 0; //计数器

    public TreeNode KthNode(TreeNode root, int k) {
        // 中序遍历寻找第k个
        if (root != null) {
            TreeNode node = KthNode(root.left, k);
            if (node != null) return node;
            index++;
            if (index == k) return root;
            node = KthNode(root.right, k);
            if (node != null) return node;
        }
        return null;
    }

    public static void main(String[] args) {
        No63 obj = new No63();
    }
}
