package breadth_first_search;

import template.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree
 * 问题：给定一个二叉搜索树的边界L和R，修剪该树使得所有元素在[L,R]范围内
 * 思路：
 */
public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 如果当前结点的值不在[L, R]之间，那么这个结点应该删除掉，那么以哪个结点来替换呢？
                // 这个倒不难：如果小于 L，那么一定是右子树结点；如果大于 R，那么一定是左子树结点。
                if (node.val < L || node.val > R) {
                    // 如果根结点值小于L，那么返回对其右子结点调用递归函数的值

                    // 如果根结点值大于R，那么返回对其左子结点调用递归函数的值

                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return root;
    }

    public TreeNode trimBSTDFS(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        TrimABinarySearchTree obj = new TrimABinarySearchTree();
        System.out.println(obj.trimBSTDFS(new TreeNode(1, new TreeNode(0), new TreeNode(2)), 1, 2).val);
        System.out.println(obj.trimBSTDFS(new TreeNode(3, new TreeNode(0, null,new TreeNode(2,new TreeNode(1),null)), new TreeNode(4)), 1, 3).val);
    }
}
// http://www.cnblogs.com/grandyang/p/7583185.html
// https://www.polarxiong.com/archives/LeetCode-669-trim-a-binary-search-tree.html
// http://blog.csdn.net/huanghanqian/article/details/77839449