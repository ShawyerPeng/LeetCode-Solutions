package sword_for_offer;

import template.TreeNode;

/**
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6
 * 问题：重建二叉树。输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列 {1,2,4,7,3,5,6,8} 和中序遍历序列 {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：
 */
public class No06 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return dfs(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode dfs(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        //  开始位置大于结束位置说明已经处理到叶节点了
        if (startPre > endPre || startIn > endIn) return null;

        // 不断寻找中序遍历中根节点的值（前序遍历第一个数字为当前的根节点）
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                // 当前节点的左子树的个数为index-is
                // 左子树对应的前序遍历的位置在preOrder[ps+1,ps+index-is]
                // 左子树对应的中序遍历的位置在inOrder[is,index-1]
                root.left = dfs(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                // 当前节点的右子树的个数为ie-index
                // 右子树对应的前序遍历位置在preOrder[ps+index-is+1,pe]
                // 右子树对应的中序遍历位置在inOrder[index+1,ie]
                root.right = dfs(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        No06 obj = new No06();
        System.out.println(obj.reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6}).val);
    }
}
// http://blog.csdn.net/qq_15062527/article/details/48846457
// http://www.cnblogs.com/gl-developer/p/6444280.html