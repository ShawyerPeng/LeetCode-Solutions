package sword_for_offer;

import template.TreeNode;

import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/564f4c26aa584921bc75623e48ca3011
 * 问题：二叉树的镜像
 * 思路：
 */
public class No19 {
    public void mirror(TreeNode root) {
        // 根节点为空或者只有根节点，不做处理
        if (root == null || (root.left == null && root.right == null)) return;

        // 交换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 把左右子树分别作为root，递归交换各自的左右子树
        if (root.left != null) mirror(root.left);
        if (root.right != null) mirror(root.right);
    }

    public void mirrorStack(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
    }

    public static void main(String[] args) {
        No19 obj = new No19();
        TreeNode root = new TreeNode(8, new TreeNode(6, new TreeNode(5), new TreeNode(7)), new TreeNode(10, new TreeNode(9), new TreeNode(11)));
        obj.mirror(root);
        System.out.println(root.left.left.val);
    }
}
