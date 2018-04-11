package tree;

import template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree
 * 问题：
 * 思路：当求最大深度时，我们只要在左右子树中取较大的就行了，然而最小深度时，如果左右子树中有一个为空会返回0，这时我们是不能算做有效深度的。
 * 所以分成了三种情况，左子树为空，右子树为空，左右子树都不为空。当然，如果左右子树都为空的话，就会返回1。
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        if (root.left != null && root.right == null) {
            depth = minDepth(root.left);
        } else if (root.left == null && root.right != null) {
            depth = minDepth(root.right);
        } else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            return Math.min(left, right);
        }
        return depth + 1;
    }

    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree obj = new MinimumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), null);
        System.out.println(obj.minDepthBFS(root));
    }
}
// https://segmentfault.com/a/1190000003748894