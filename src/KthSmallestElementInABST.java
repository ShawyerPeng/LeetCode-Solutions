import template.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst
 * 问题：找出平衡二叉树的第k小的元素
 * 思路：用 BST 的性质来解题，最重要的性质是就是左 < 根 < 右，那么如果用中序遍历所有的节点就会得到一个有序数组。
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        List<Integer> results = new ArrayList<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            results.add(node.val);
            node = node.right;
        }
        return results.get(k - 1);
    }

    public static void main(String[] args) {
        KthSmallestElementInABST obj = new KthSmallestElementInABST();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
        System.out.println(obj.kthSmallest(root, 2));
    }
}
// http://www.cnblogs.com/grandyang/p/4620012.html