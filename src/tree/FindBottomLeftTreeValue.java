package tree;

import template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value
 * 问题：找到二叉树的最后一层的最左边的值（假定root是非null的）
 * 思路：
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 更新每一层的最左边元素
                if (i == 0) result = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindBottomLeftTreeValue obj = new FindBottomLeftTreeValue();
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(obj.findBottomLeftValue(root));
        root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6)));
        System.out.println(obj.findBottomLeftValue(root));
    }
}
// http://www.cnblogs.com/grandyang/p/6405128.html
// http://blog.csdn.net/mine_song/article/details/70213855