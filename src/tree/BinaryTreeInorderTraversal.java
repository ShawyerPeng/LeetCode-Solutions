package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 * 问题：二叉树中序遍历
 * 思路：由于二叉树中序遍历要先遍历左孩子而后根节点，最后是右孩子。
 * 所以算法先找到根节点的最左孩子，把一路下来的左孩子依次入栈，访问最左孩子，而后是访问根节点，然后把根节点右孩子当做当前节点
 * 重复上述过程直到节点都访问完。
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) return results;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            // 左孩子依次入栈，访问最左孩子
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // cur为空循环结束，说明已经到达最左下节点，访问它并添加到结果
            node = stack.pop();
            results.add(node.val);
            // 把根节点右孩子当做当前节点
            node = node.right;
        }
        return results;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(obj.inorderTraversal(root));
    }
}
