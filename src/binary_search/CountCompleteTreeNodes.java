package binary_search;

import template.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes
 * 问题：计算完全二叉树的节点数。
 * 完全二叉树：从根结点到倒数第二层满足完美二叉树，最后一层可以不完全填充，其叶子结点都靠左对齐。
 * 思路：高度为 h 的完全二叉树，其节点个数等于高度为 h-1 的满二叉树的节点个数 + 最后一层的节点个数。
 * 因此，只需要二分枚举第 h 层的节点个数即可。
 * 将第 h 层的节点从 0 至 2^h - 1 依次编号（根节点的层数记为 0）
 * 若用 0 表示左孩子，1 表示右孩子，则这些编号的二进制形式是从根节点出发到叶子节点的 “路径”。
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int depth = 0;
        TreeNode node = root;
        while (node != null) {
            depth++;
            node = node.left;
        }
        if (depth == 0) {
            return 0;
        }
        int left = 0, right = (1 << (depth - 1)) - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (getNode(root, mid, depth - 1) != null) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (1 << (depth - 1)) + right;
    }

    private TreeNode getNode(TreeNode root, int path, int depth) {
        while (depth-- != 0 && root != null) {
            if ((path & (1 << depth)) != 0) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes obj = new CountCompleteTreeNodes();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(obj.countNodes(root));
    }
}
// http://bookshadow.com/weblog/2015/06/06/leetcode-count-complete-tree-nodes/
// https://segmentfault.com/a/1190000003818177