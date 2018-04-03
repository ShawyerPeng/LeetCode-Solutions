package sword_for_offer;

import template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/questionTerminal/435fb86331474282a3499955f0a41e8b
 * 问题：二叉树的深度
 * 思路：
 */
public class No39 {
    public int treeDepth(TreeNode root) {
        if (root == null) return 0;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public int treeDepthNonRec(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        No39 obj = new No39();
        System.out.println(obj.treeDepth(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5))));
    }
}
