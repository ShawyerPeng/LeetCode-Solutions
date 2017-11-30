package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/recover-binary-search-tree
 * 问题：Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 思路：
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> results = new ArrayList<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            results.add(node.val);
            node = node.right;
        }

        int size = results.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = results.get(i);
        }
        Arrays.sort(res);

        int i = 0;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            // 修改为正确的值
            root.val = res[i];
            i++;
            root = root.right;
        }
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree obj = new RecoverBinarySearchTree();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        obj.recoverTree(root);
    }
}
// https://www.tianmaying.com/tutorial/LC99
// http://blog.csdn.net/qq_25022233/article/details/66473051