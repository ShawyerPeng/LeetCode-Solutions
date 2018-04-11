package tree;

import template.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row
 * 问题：
 * 思路：BFS 层序遍历，然后在每一层中找到最大值，加入结果 res 中即可
 */
public class FindLargestValueInEachTreeRow {
    /**
     * BFS
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                System.out.println(queue.toArray(new TreeNode[queue.size()]).length);
            }
            results.add(Collections.max(level));
            level.clear();
        }
        return results;
    }

    /**
     * DFS
     */
    public List<Integer> largestValuesDFS(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;

        helper(root, 1, results);

        return results;
    }

    private void helper(TreeNode root, int depth, List<Integer> res) {
        if (depth > res.size()) {
            res.add(root.val);
        } else {
            res.set(depth - 1, Math.max(res.get(depth - 1), root.val));
        }
        if (root.left != null) helper(root.left, depth + 1, res);
        if (root.right != null) helper(root.right, depth + 1, res);
    }

    public static void main(String[] args) {
        FindLargestValueInEachTreeRow obj = new FindLargestValueInEachTreeRow();
        //TreeNode root = new TreeNode(5, new TreeNode(2, null, null), new TreeNode(-3, null, null));
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        System.out.println(obj.largestValues(root));
        System.out.println(obj.largestValuesDFS(root));
    }
}
// http://www.cnblogs.com/grandyang/p/6417826.html
// http://blog.csdn.net/mrbcy/article/details/63280539
// http://www.voidcn.com/article/p-pacfmgjj-hh.html