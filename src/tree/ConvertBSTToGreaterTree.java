package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree
 * 问题：每个节点的值等于自己加上大于它的所有数字的和
 * 思路：
 */
public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> results = new ArrayList<>();
        TreeNode node = root;
        TreeNode prev = root;
        // 先中序遍历一遍
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
            for (int j = i; j < size; j++)
                res[i] += results.get(j);
        }

        int i = 0;
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            // 修改为改变后的值
            root.val = res[i];
            i++;
            root = root.right;
        }

        return prev;
    }

    public static void main(String[] args) {
        ConvertBSTToGreaterTree obj = new ConvertBSTToGreaterTree();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(obj.convertBST(root).val);
    }
}
// http://blog.csdn.net/camellhf/article/details/72615469
// https://segmentfault.com/a/1190000009401211