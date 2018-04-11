package tree;

import template.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum
 */
public class MostFrequentSubtreeSum {
    private int max = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        if (root != null) countSum(root, sumToCount);
        List<Integer> maxSum = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : sumToCount.entrySet()) {
            int count = pair.getValue();
            if (count == max) maxSum.add(pair.getKey());
        }
        int[] res = new int[maxSum.size()];
        for (int i = 0; i < maxSum.size(); i++) {
            res[i] = maxSum.get(i);
        }
        return res;
    }

    private int countSum(TreeNode root, Map<Integer, Integer> sumToCount) {
        int sum = root.val;
        if (root.left != null) sum += countSum(root.left, sumToCount);
        if (root.right != null) sum += countSum(root.right, sumToCount);
        int count = sumToCount.containsKey(sum) ? sumToCount.get(sum) + 1 : 1;
        sumToCount.put(sum, count);
        max = Math.max(max, count);
        return sum;
    }

    public static void main(String[] args) {
        MostFrequentSubtreeSum obj = new MostFrequentSubtreeSum();
    }
}
