package breadth_first_search;

import template.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 * 问题：
 * 思路：
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            // 每次将level添加到0索引处，这样就是bottom-up顺序保存的
            results.add(0, level);
        }

        return results;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII obj = new BinaryTreeLevelOrderTraversalII();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(Arrays.toString(new List[]{obj.levelOrderBottom(root)}));
    }
}
