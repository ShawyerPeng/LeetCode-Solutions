package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-paths
 * 问题：
 * 思路：
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        if (root == null) return results;
        helper(root, new StringBuilder(), results);
        return results;
    }

    private void helper(TreeNode root, StringBuilder path, List<String> results) {
        // 递归结束条件1
        if (root == null) return;
        // 保存未进行进一步操作的字符串长度，以便后面的回溯
        int len = path.length();
        path.append(root.val).append("->");
        if (root.left == null && root.right == null) {
            // 递归结束条件2，到达叶子结点，收集路径（注意把"->"截取掉）
            results.add(path.toString().substring(0, path.length() - 2));
        } else {
            if (root.left != null) helper(root.left, path, results);
            if (root.right != null) helper(root.right, path, results);
        }
        // 在递归调用中任何对局部变量的修改都需要回溯，以保证最上层调用者使用的局部变量和传入时的值一样
        path.setLength(len);
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
        if (root.left == null && root.right == null) results.add(path);
        if (root.left != null) dfs(root.left, path + "->" + root.left.val, results);
        if (root.right != null) dfs(root.right, path + "->" + root.right.val, results);
    }

    public static void main(String[] args) {
        BinaryTreePaths obj = new BinaryTreePaths();
        System.out.println(obj.binaryTreePaths(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
        System.out.println(obj.binaryTreePaths2(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3))));
    }
}
// http://blog.csdn.net/crazy1235/article/details/51474128