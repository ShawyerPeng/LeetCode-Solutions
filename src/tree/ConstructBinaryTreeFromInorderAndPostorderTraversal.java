package tree;

import template.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 问题：给出二叉树的中序和后序遍历的结果，构建该二叉树
 * 思路：在 inorder 中找 root（），从而得以分割 left/right subtree，并通过递归来重构。
 * postorder 序列中最后一个数一定是当前二叉树的根节点root。又因为二叉树不存在相同的数，我们可以找到root在中序遍历中位置p。
 * 则我们可以分别找到两颗子树对应的中序和后序遍历：
 * 左子树的中序 = inOrder[1 .. p - 1]
 * 左子树的后序 = postOrder[1 .. p - 1]
 * 右子树的中序 = inOrder[p + 1 .. n]
 * 右子树的后序 = postOrder[p .. n - 1]
 * 在此基础上我们就可以递归处理两颗子树。
 * 当我们发现当前中序遍历和后序遍历长度都为 1 的时候，也就找到了叶子节点，此时我们开始回溯。
 * <p>
 * 性质：已知二叉树的两个遍历序列构造二叉树，有如下性质：
 * 若已知先序和中序，则可以构造出唯一的二叉树
 * 若已知先序和后序，则可以构造出多颗不同的二叉树
 * 若已知中序和后序，则可以构造出唯一的二叉树
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    private int pInorder;
    private int pPostorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return helper(inorder, postorder, null);
    }

    private TreeNode helper(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) return null;
        // postorder最后一个元素为二叉树的根节点
        TreeNode root = new TreeNode(postorder[pPostorder--]);
        // if right node exist, create right subtree
        if (inorder[pInorder] != root.val) {
            // inorder的最后一个元素也就是整个二叉树的最右下节点
            // postorder从最后往前遍历到inorder的最后一个节点，也就相当于一直往右子树遍历到底
            root.right = helper(inorder, postorder, root);
        }
        // inorder的第一个根节点已经得到了
        pInorder--;
        // if left node exist, create left subtree
        if ((end == null) || (inorder[pInorder] != end.val)) {
            //
            root.left = helper(inorder, postorder, end);
        }
        return root;
    }

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        // 保存中序遍历根节点索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return helper2(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder, map);
    }

    private TreeNode helper2(int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder, Map<Integer, Integer> map) {
        if (postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        // postorder的最后一个元素一定是二叉树的根节点
        int inRoot = map.get(postorder[postEnd]);
        root.left = helper2(inStart, inRoot - 1, postStart, postStart + (inRoot - inStart - 1), inorder, postorder, map);
        root.right = helper2(inRoot + 1, inEnd, postStart + (inRoot - inStart), postEnd - 1, inorder, postorder, map);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal obj = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode root = obj.buildTree2(inorder, postorder);
        System.out.println(root.right.left.val);
    }
}