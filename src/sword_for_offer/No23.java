package sword_for_offer;

import template.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.nowcoder.com/questionTerminal/7fe2212963db4790b57431d9ed259701
 * 问题：从上往下打印二叉树
 * 思路：
 */
public class No23 {
    public List<Integer> printFromTopToBottom(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                results.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        No23 obj = new No23();
        TreeNode root = new TreeNode(8, new TreeNode(6, new TreeNode(5), new TreeNode(7)), new TreeNode(10, new TreeNode(9), new TreeNode(11)));
        System.out.println(obj.printFromTopToBottom(root));
    }
}
