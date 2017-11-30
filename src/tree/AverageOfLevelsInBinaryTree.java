package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree
 * 问题：
 * 思路：
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            int count = 0;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                sum += node.val;
                count++;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            results.add((double) sum / count);
        }
        return results;
    }

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree obj = new AverageOfLevelsInBinaryTree();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(obj.averageOfLevels(root));
        root = new TreeNode(2147483647, new TreeNode(2147483647), new TreeNode(2147483647));
        System.out.println(obj.averageOfLevels(root));
    }
}
