package depth_first_search;

import template.TreeNode;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) return null;
        return dfs(0, inorder.length - 1, 0, postorder.length - 1, inorder, postorder);
    }

    private TreeNode dfs(int leftInorder, int rightInorder, int leftPostorder, int rightPostorder, int[] inorder, int[] postorder) {
        if (leftInorder > rightInorder || leftPostorder > rightPostorder) return null;
        // 生成根节点
        TreeNode root = new TreeNode(postorder[rightPostorder]);
        // 找到根在中序遍历中的位置
        int rootIndex = -1;
        for (int i = leftInorder; i <= rightInorder; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) return null;
        int leftTreeSize = rootIndex - leftInorder;
        int rightTreeSize = rightInorder - rootIndex;

        // 递归处理两个子树
        root.left = dfs(leftInorder, rootIndex - 1, leftPostorder, leftPostorder + leftTreeSize - 1, inorder, postorder);
        root.right = dfs(rootIndex + 1, rightInorder, rightPostorder - rightTreeSize, rightPostorder - 1, inorder, postorder);

        // 返回根节点
        return root;
    }

    public static void main(String[] args) {

    }
}
// http://bangbingsyb.blogspot.com/2014/11/leetcode-construct-binary-tree-from_11.html
// https://www.tianmaying.com/tutorial/LC106