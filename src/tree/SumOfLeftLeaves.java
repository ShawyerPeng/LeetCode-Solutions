package tree;

import template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-left-leaves
 * 问题：左子叶之和
 * 思路：
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return 0;

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            // 左节点不为空且左节点是叶子结点，则把左节点的值添加到和里
            if (curr.left != null && curr.left.left == null && curr.left.right == null) sum += curr.left.val;
            // 左右子节点入栈
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
        return sum;
    }

    public int sumOfLeftLeavesStack(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode t = stack.peek();
            stack.pop();
            if (t.left != null && t.left.left == null && t.left.right == null) res += t.left.val;
            if (t.left != null) stack.push(t.left);
            if (t.right != null) stack.push(t.right);
        }
        return res;
    }

    /**
     * 由于我们只需要累加左子叶之和，那么我们在进入递归函数的时候需要知道当前结点是否是左子节点
     * 如果是左子节点，而且该左子节点再没有子节点了说明其是左子叶，那么我们将其值加入结果 res 中
     * 我们用一个 bool 型的变量，如果为 true 说明当前结点是左子节点
     * 若为 false 则说明是右子节点，不做特殊处理，整个来说就是个递归的先序遍历的写法
     */
    public int sumOfLeftLeavesDFS(TreeNode root) {
        return dfs(root, false);
    }

    /**
     * 是不是 left 子数完全由 bottom 往上第二层决定，如果是 left 子树且是叶子节点，那么就是 left leaves, parent 得告诉 child 是不是在 left 子树
     */
    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (isLeft && root.left == null && root.right == null) return root.val;
        return dfs(root.left, true) + dfs(root.right, false);
    }

    /**
     * 对于结点本身，虽然可以很容易判断其是否为叶子结点，但不能判断其是否为左结点。
     * 这里有个解决办法就是，既然遍历会遍历到每个结点，那不妨对每个结点检查其左子节点是不是叶子结点就好了
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOfLeftLeaves obj = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(obj.sumOfLeftLeaves(root));
        System.out.println(obj.sumOfLeftLeavesDFS(root));
        System.out.println(obj.sumOfLeftLeavesStack(root));
    }
}
// http://www.cnblogs.com/EdwardLiu/p/6117130.html
// http://www.cnblogs.com/grandyang/p/5923559.html
// https://dyang2016.wordpress.com/2016/09/29/404-sum-of-left-leaves/