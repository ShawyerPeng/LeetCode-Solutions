package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-tilt
 * 问题：二叉树的坡度定义为该结点的左子树之和与右子树之和的差的绝对值，求所有结点的坡度之和。
 * 思路：后序遍历，这样就可以从叶子结点开始搜索，便于求和
 */
public class BinaryTreeTilt {
    private int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        // 左右子树的差的绝对值
        res += Math.abs(left - right);
        // 函数的返回值是当前根节点的值加上左右子树的和
        return left + right + root.val;
    }

    //public int findTilt(TreeNode root) {
    //    if (root == null || root.left == null && root.right == null) return 0;
    //
    //    ArrayList<Integer> result = new ArrayList<>();
    //    Stack<TreeNode> stack = new Stack<>();
    //
    //    TreeNode prev = null; // previously traversed node
    //    TreeNode cur = root;
    //
    //    stack.push(root);
    //    while (!stack.empty()) {
    //        cur = stack.peek();
    //        if (prev == null || prev.left == cur || prev.right == cur) { // traverse down the tree
    //            if (cur.left != null) {
    //                stack.push(cur.left);
    //            } else if (cur.right != null) {
    //                stack.push(cur.right);
    //            }
    //        } else if (cur.left == prev) { // traverse up the tree from the left
    //            if (cur.right != null) {
    //                stack.push(cur.right);
    //            }
    //        } else { // traverse up the tree from the right
    //            result.add(cur.val);
    //            stack.pop();
    //        }
    //        prev = cur;
    //    }
    //    return result;
    //}

    public int findTiltDFS(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[]{0};
        dfs(root, result);
        return result[0];
    }

    // 表示以root为根节点的所有子节点(包括本身)之和
    private int dfs(TreeNode root, int[] result) {
        if (root == null) return 0;
        int left = dfs(root.left, result);
        int right = dfs(root.right, result);
        result[0] += Math.abs(left - right);
        return left + right + root.val;
    }

    /**
     * 后序DFS遍历，用一个 res 来保存左右差的结果，函数的返回值是左右子树的和加上根节点的值。这样统计之后就能求出所有左右子树的和的差值。
     */
    public int findTiltPostOrderDFS(TreeNode root) {
        int[] result = new int[]{0};
        postOrder(root, result);
        return result[0];
    }

    private int postOrder(TreeNode root, int[] result) {
        if (root == null) return 0;

        int left = postOrder(root.left, result);
        int right = postOrder(root.right, result);

        result[0] += Math.abs(left - right);

        return left + right + root.val;
    }

    public static void main(String[] args) {
        BinaryTreeTilt obj = new BinaryTreeTilt();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        //System.out.println(obj.findTilt(root));
        System.out.println(obj.findTiltDFS(root));
        System.out.println(obj.findTiltPostOrderDFS(root));
    }
}
// http://www.voidcn.com/article/p-ahlghios-hk.html
// http://www.cnblogs.com/grandyang/p/6786643.html