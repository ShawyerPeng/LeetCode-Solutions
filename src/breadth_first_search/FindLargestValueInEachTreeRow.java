package breadth_first_search;

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

        //Java queue 是使用 poll 來 當作 pop , offer 當作 push
        Queue<TreeNode> queue = new LinkedList<>();
        // 添加一个元素并返回 true
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            // 必须要这行！！！
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 访问再移除队列头部的元素
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) queue.offer(head.left);
                if (head.right != null) queue.offer(head.right);
                System.out.println(queue.toArray(new TreeNode[queue.size()]).length);
            }
            results.add(Collections.max(level));
            level.clear();
        }

        return results;
    }

    /**
     * DFS。
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