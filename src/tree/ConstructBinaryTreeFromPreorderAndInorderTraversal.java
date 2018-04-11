package tree;

import template.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * 左孩子在preorder中找，右孩子在inorder中找
     *
     * @param preStart:preorder的起始位置
     * @param inStart:inorder的起始位置
     * @param inEnd:inorder的结束位置
     */
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        // preorder的第一个元素一定是二叉树的根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 表示在inorder中当前根节点的位置
        int inRoot = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRoot = i;
                break;
            }
        }
        // preorder中当前根节点右边一个元素一定是根节点的左孩子
        // 左孩子一定在preorder的后部分[preStart+1,end]中，inorder的前部分[inStart,inIndex-1]中
        root.left = helper(preStart + 1, inStart, inRoot - 1, preorder, inorder);
        // inorder中当前根节点右边一个元素一定是根节点的右孩子
        // 通过inorder找到左孩子一共有多少个(inIndex-inStart)，这样就可以得到右子树的起始位置
        root.right = helper(preStart + (inRoot - inStart) + 1, inRoot + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = obj.buildTree(preorder, inorder);
        System.out.println(root.right.left.val);
    }
}
