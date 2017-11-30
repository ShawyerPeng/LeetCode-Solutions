package tree;

import template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/add-one-row-to-tree
 * 问题：
 * 思路：
 */
public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return null;
        // 当d==1时，需要替换根结点
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 检测到 d 为 0 时，直接返回，因为添加操作已经完成，没必要遍历完剩下的结点
            if (--d == 0) return root;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 当 d==1 时，需要插入该行
                if (d == 1) {
                    TreeNode left = new TreeNode(v);
                    left.left = node.left;
                    node.left = left;

                    TreeNode right = new TreeNode(v);
                    right.right = node.right;
                    node.right = right;
                } else {
                    // 如果 d 不为 1，那么就是层序遍历原有的入队操作
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        AddOneRowToTree obj = new AddOneRowToTree();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
        System.out.println(obj.addOneRow(root, 1, 2).left.left.val);
    }
}
// http://www.cnblogs.com/grandyang/p/7070182.html