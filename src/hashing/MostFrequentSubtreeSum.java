package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum
 * 问题：求出现频率最高的子树和
 * 思路：
 * 1. 暴力解法：遍历每个结点，对于每个结点都看作子树的根结点，然后再遍历子树所有结点求和
 * 2. 哈希表 后序遍历：我们想下子树有何特点，必须是要有叶结点，单独的一个叶结点也可以当作是子树，那么子树是从下往上构建的，这种特点很适合使用后序遍历
 * 我们使用一个哈希表来建立子树和跟其出现频率的映射，用一个变量 cnt 来记录当前最多的次数，递归函数返回的是以当前结点为根结点的子树结点值之和
 * 然后在递归函数中，我们先对当前结点的左右子结点调用递归函数，然后加上当前结点值，然后更新对应的哈希表中的值
 * 然后看此时哈希表中的值是否大于等于 cnt，大于的话首先要清空 res，等于的话不用，然后将 sum 值加入结果 res 中即可
 */
public class MostFrequentSubtreeSum {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static Map<Integer, Integer> sumMap = new HashMap<>();
    private static List<Integer> results = new ArrayList<>();
    private static int maxCount;

    public static int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[]{};

        postOrder(root);

        for (int key : sumMap.keySet()) {
            if (sumMap.get(key) == maxCount && !results.contains(key)) {
                results.add(key);
            }
        }

        int[] res = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            res[i] = results.get(i);
        }
        return res;
    }

    private static int postOrder(TreeNode node) {
        if (node == null) return 0;
        // 遍历左树，并返回左树的和
        int left = postOrder(node.left);
        // 遍历右树，并返回右树的和
        int right = postOrder(node.right);
        // 加上本节点值，将其保存到Map中并返回上一层节点
        int sum = left + right + node.val;

        sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        if (sumMap.get(sum) >= maxCount) {
            if (sumMap.get(sum) > maxCount) results.clear();
            results.add(sum);
            maxCount = sumMap.get(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFrequentTreeSum(new TreeNode(5, new TreeNode(2, null, null), new TreeNode(-3, null, null)))));
        System.out.println(Arrays.toString(findFrequentTreeSum(new TreeNode(5, new TreeNode(2, null, null), new TreeNode(-5, null, null)))));
    }

}
// http://www.cnblogs.com/grandyang/p/6481682.html