package tree;

import template.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/symmetric-tree
 */
public class SymmetricTree {
    /**
     * BFS 非递归，使用Queue
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        // Java queue 是使用 offer 当作 push，poll 來当作 front + pop
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        // 先将头节点入queue，分别对左右子树进行 BFS 的一层一层地访问
        queue1.offer(root.left);
        queue2.offer(root.right);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // 每一次queue出列一个node，然后检查这个node的左右子节点
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            // 两个子树都为null，直接跳过
            if (node1 == null && node2 == null) continue;
            // 有一个子树为null，这种情况返回false
            if ((node1 != null && node2 == null) || (node1 == null && node2 != null)) return false;

            // 两个子树都不为null。在访问中压入子节点到两个 queue 时，采用完全相反的顺序
            if (node1.val != node2.val) return false;
            // 对左子树先压入 left child 再 right child
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            // 对右子树先压入 right child 再 left child
            queue2.offer(node2.right);
            queue2.offer(node2.left);
        }

        if (!queue1.isEmpty() || !queue2.isEmpty()) return false;

        return true;
    }

    /**
     * DFS 递归
     */
    public boolean isSymmetricDFSRec(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return (helper(left.left, right.right) && helper(left.right, right.left));
    }

    /**
     * DFS 非递归，使用Stack
     */
    public boolean isSymmetricDFSStack(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode p1 = stack.pop();
            TreeNode p2 = stack.pop();
            if (p1 == null && p2 == null) {
                continue;
            }
            if (p1 == null || p2 == null || p1.val != p2.val) {
                return false;
            }
            stack.push(p1.left);
            stack.push(p2.right);
            stack.push(p1.right);
            stack.push(p2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        SymmetricTree obj = new SymmetricTree();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(obj.isSymmetric(root));
        System.out.println(obj.isSymmetricDFSRec(root));
        System.out.println(obj.isSymmetricDFSStack(root));
        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(obj.isSymmetric(root));
        System.out.println(obj.isSymmetricDFSRec(root));
        System.out.println(obj.isSymmetricDFSStack(root));
    }
}
// http://bangbingsyb.blogspot.com.br/2014/11/leetcode-symmetric-tree.html
// http://www.cnblogs.com/grandyang/p/4051715.html
// http://blog.csdn.net/cslbupt/article/details/53968899