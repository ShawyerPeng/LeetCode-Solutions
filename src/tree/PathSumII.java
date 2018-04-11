package tree;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        helper(root, 0, sum, new ArrayList<>(), results);
        return results;
    }

    private void helper(TreeNode root, int sum, int target, List<Integer> path, List<List<Integer>> results) {
        if (root == null) return;
        sum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                results.add(new ArrayList<>(path));
            }
        }
        helper(root.left, sum, target, path, results);
        helper(root.right, sum, target, path, results);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII obj = new PathSumII();
    }
}
