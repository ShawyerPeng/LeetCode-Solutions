package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/print-binary-tree
 * 问题：将二叉树输出成 m * n 二维数组。行数 m 等于二叉树的高度，列数 n 总是奇数，根节点位于首行正中间，将其下的空间分成左右两半。递归此过程。
 * 思路：递归（Recursion），根据深度 + 偏移量确定节点在二维数组中的位置。
 * 设树的总深度为height，则二维数组宽度width = (1 << height) - 1
 * 根节点的位置offset = width >> 1，深度depth = 1
 * 左子树根的位置为offset - (1 + width >> depth + 1)
 * 右子树根的位置为offset + (1 + width >> depth + 1)
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res)
            Arrays.fill(arr, "");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res)
            ans.add(Arrays.asList(arr));
        return ans;
    }

    private void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null)
            return;
        res[i][(l + r) / 2] = "" + root.val;
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        PrintBinaryTree obj = new PrintBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        System.out.println(obj.printTree(root));
    }
}
// https://leetcode.com/problems/print-binary-tree/solution/