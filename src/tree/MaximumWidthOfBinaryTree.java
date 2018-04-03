package tree;

import template.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree
 * 问题：求二叉树的最大宽度，根据题目中的描述可知，这里的最大宽度不是满树的时候的最大宽度，如果是那样的话，肯定是最后一层的结点数最多。
 * 这里的最大宽度应该是两个存在的结点中间可容纳的总的结点个数，中间的结点可以为空。
 * 思路：左子树节点是根节点的2倍
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        // 用于树的广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 用于保存上面队列中树节点对应的位置标号
        Queue<Integer> queuePos = new LinkedList<>();
        queue.offer(root);
        // 在顶层跟结点位置为1
        queuePos.add(1);

        // 首先判断此队列是否为空
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 每一层中第一个节点的下标
            int start = queuePos.peek();
            // 每一层中最大孩子的位置下标
            int end = start;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                end = queuePos.poll();
                // 从左子树头节点开始，走到最后一个节点
                if (node.left != null) {
                    queue.offer(node.left);
                    // 左孩子的下标
                    queuePos.offer(2 * end);
                }
                // 从右子树头节点开始，走到最后一个节点
                if (node.right != null) {
                    queue.offer(node.right);
                    // 右孩子的下标
                    queuePos.offer(2 * end + 1);
                }
            }
            result = Math.max(end - start + 1, result);
        }
        return result;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        int result = 0;
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indice = new LinkedList<>();
        queue.offer(root);
        indice.offer(0);
        // 当前层最左边和最右边的Id
        int leftId = 0, rightId = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = indice.poll();
                if (i == 0) leftId = index;
                if (i == size - 1) rightId = index;

                if (node.left != null) {
                    queue.offer(node.left);
                    indice.offer(index * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indice.offer(index * 2 + 1);
                }
            }
            result = Math.max(result, rightId - leftId + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        System.out.println(obj.widthOfBinaryTree(root));
    }
}
// http://blog.csdn.net/sun_wangdong/article/details/77803761
// http://www.cnblogs.com/grandyang/p/7538821.html
// https://irisjavadiary.blogspot.com.br/2017/09/662-maximum-width-of-binary-tree.html
// http://www.voidcn.com/article/p-fvunixcy-bnv.html
// http://www.techiedelight.com/find-maximum-width-given-binary-tree/
// https://www.jianshu.com/p/7a76cdbbd68f