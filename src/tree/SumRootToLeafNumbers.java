package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers
 * 问题：给定一个值范围在[0,9]的二叉树，每个root-leaf的路径都代表一个数字，求这些数字的和
 * 思路：只需在遍历过程中记录路径中的数字，在到达叶节点的时候把记录下来的数字转换成数值，加到和里面即可。
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    }

    /**
     * 更简洁的形式
     */
    public int sumNumbers2(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        if (root.left != null) root.left.val += root.val * 10;
        if (root.right != null) root.right.val += root.val * 10;
        return sumNumbers2(root.left) + sumNumbers2(root.right);
    }

    /**
     * 前序遍历。树的解决问题方式必须依靠访问，访问无非四种方式。
     */
    public int sumNumbers3(TreeNode root) {
        if (root == null) return 0;
        return helper2(root, 0);
    }

    private int helper2(TreeNode root, int prev) {
        int curr = root.val + 10 * prev;
        if (root.left == null && root.right == null) {
            return curr;
        } else if (root.left == null) {
            return helper2(root.right, curr);
        } else if (root.right == null) {
            return helper2(root.left, curr);
        } else {
            return helper2(root.left, curr) + helper2(root.right, curr);
        }
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
        System.out.println(obj.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(obj.sumNumbers(new TreeNode(0, new TreeNode(1), new TreeNode(3))));
        System.out.println(obj.sumNumbers2(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(obj.sumNumbers3(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }
}
// http://www.jianshu.com/p/ef4d2dcf33d5
// https://www.sigmainfy.com/blog/leetcode-sum-root-leaf.html