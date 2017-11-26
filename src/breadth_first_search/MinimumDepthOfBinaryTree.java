package breadth_first_search;

import template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 * 问题：求二叉树的Minimum Depth。Minimum Depth是由根节点到最近的叶子结点的深度
 * 思路：BFS
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int minDepth = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode node = queue.poll();
                // 若发现node既没有left结点也没有right结点（即叶子结点）时直接return minDepth，否则在每一层遍历完成后minDepth++
                // 即在检测到第一个叶子的时候就可以返回了
                if (node.left == null && node.right == null) return minDepth;
                // 将 node 出队的同时将 node.left 和 node.right 入队
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            minDepth++;
        }

        return minDepth;
    }

    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }
    private int getMin(TreeNode root){
        if (root == null) return Integer.MAX_VALUE;

        if (root.left == null && root.right == null) return 1;

        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree obj = new MinimumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(3, null, null), new TreeNode(2, null, new TreeNode(9)));
        System.out.println(obj.minDepth(root));
    }
}
