package depth_first_search;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths
 * 问题：
 * 思路：
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(sb, root, results);
        return results;
    }

    private void dfs(StringBuilder sb, TreeNode root, List<String> results) {
        if (root == null) return;
        // 保存未进行进一步操作的字符串长度，以便后面的回溯
        int len = sb.length();
        sb.append(root.val).append("->");
        if (root.left == null && root.right == null) {
            results.add(sb.toString().substring(0, sb.length() - 2));
        } else {
            if (root.left != null) dfs(sb, root.left, results);
            if (root.right != null) dfs(sb, root.right, results);
        }
        // 截取（回溯）
        sb.setLength(len);
    }

    /**
     * 单条路径不需要通过一个 List 集合来存储，直接通过字符串构造出来
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> results = new ArrayList<>();
        if (root == null) return results;
        dfs(root, root.val + "", results);
        return results;
    }

    private void dfs(TreeNode root, String path, List<String> results) {
        if (root.left == null && root.right == null) {
            results.add(path);
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + root.left.val, results);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + root.right.val, results);
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths obj = new BinaryTreePaths();
        System.out.println(obj.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
        System.out.println(obj.binaryTreePaths2(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
    }
}
// http://blog.csdn.net/crazy1235/article/details/51474128