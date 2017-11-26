package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree
 * 问题：根据二叉树创建字符串
 * Input: Binary tree: [1,2,3,null,4]
 *    1
 *  /   \
 * 2     3
 *  \
 *   4
 * Output: "1(2()(4))(3)"
 * 思路：如果左子结点为空，右子结点不为空时，需要在父结点后加上个空括号，而右子结点如果不存在，或者左右子结点都不存在就不需要这么做
 * 如果当前结点不存在，直接返回，然后要在当前结点值前面加上左括号，然后判断，如果左子结点不存在，而右子结点存在的话，要在结果 res 后加上个空括号
 * 然后分别对左右子结点调用递归函数，调用完之后要加上右括号，形成封闭的括号。由于最外面一层的括号不需要，所以我们再返回最终结果之前要去掉首尾的括号
 * 总结规律：
 * 当左节点为空，右节点不为空，左节点的空括号保留。
 * 当左节点不为空，右节点为空，右节点的空括号可以去掉
 * 当左右节点均为空，两个空括号都要去掉。
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null) return "";

        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        // 去掉首尾的括号
        return sb.subSequence(1, sb.length() - 1).toString();
    }

    private void helper(TreeNode t, StringBuilder sb) {
        // 如果当前结点不存在，直接返回
        if (t == null) return;
        // 在当前结点值前面加上左括号
        sb.append("(" + t.val);

        // 如果左子结点不存在而右子结点存在，要在结果 sb 后加上个空括号
        if (t.left == null && t.right != null) sb.append("()");

        // 分别对左右子结点调用递归函数
        helper(t.left, sb);
        helper(t.right, sb);
        // 调用完之后要加上右括号，形成封闭的括号
        sb.append(")");
    }

    public static void main(String[] args) {
        ConstructStringFromBinaryTree obj = new ConstructStringFromBinaryTree();
        TreeNode t = new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(obj.tree2str(t));
    }
}
// http://www.cnblogs.com/grandyang/p/7000040.html