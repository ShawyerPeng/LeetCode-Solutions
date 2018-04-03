package sword_for_offer;

import template.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.nowcoder.com/questionTerminal/b736e784e3e34731af99065031301bca
 * 问题：二叉树中和为某一值的路径
 * 思路：
 */
public class No25 {
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, int target) {
        if (root == null) return results;
        path.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            // 因为add添加的是引用，如果不new一个的话，后面的操作会更改这个list
            results.add(new ArrayList<>(path));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        // 深度遍历完一条路径后要回退一步
        path.remove(path.size() - 1);
        return results;
    }

    public static void main(String[] args) {
        No25 obj = new No25();
        System.out.println(obj.findPath(new TreeNode(10, new TreeNode(5, new TreeNode(4), new TreeNode(7)), new TreeNode(12)), 22));
    }
}
