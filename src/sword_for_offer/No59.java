package sword_for_offer;

import template.TreeNode;

/**
 * 问题：对称的二叉树
 * 思路：就是判断每个节点是否相等，每个节点的左子树是否与右子树相等
 */
public class No59 {
    // 需要递归
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) return true;
        if (pRoot1 == null || pRoot2 == null) return false;

        if (pRoot1.val != pRoot2.val) return false;

        // 第一棵树使用前序遍历，第二棵树使用对称前序遍历（根，右子树，左子树）
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }

    public static void main(String[] args) {
        No59 obj = new No59();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println(obj.isSymmetrical(root));
        root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println(obj.isSymmetrical(root));
    }
}
// http://blog.csdn.net/u013398759/article/details/75647423