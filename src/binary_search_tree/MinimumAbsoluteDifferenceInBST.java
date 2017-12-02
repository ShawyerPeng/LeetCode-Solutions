package binary_search_tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst
 * 问题：
 * 思路：
 */
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return -1;

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> results = new ArrayList<>();
        TreeNode node = root;
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

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < results.size(); i++) {
            min = Math.min(Math.abs(results.get(i) - results.get(i - 1)), min);
        }

        return min;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBST obj = new MinimumAbsoluteDifferenceInBST();
        TreeNode root = new TreeNode(1, null, new TreeNode(3, new TreeNode(2), null));
        System.out.println(obj.getMinimumDifference(root));
    }
}
// http://www.cnblogs.com/grandyang/p/6540165.html
// http://blog.csdn.net/zhouziyu2011/article/details/57415243