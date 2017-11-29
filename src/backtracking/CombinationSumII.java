package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 问题：Each number in C may only be used once in the combination. 每个 candidate 只能用一次
 * 思路：只需要在调用下一层递归时，查找范围的起始数字不是当前数字而是下一个数字即可。
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return results;

        // 先将candidate数组排序避免重复搜索
        Arrays.sort(candidates);

        // 中间结果
        ArrayList<Integer> path = new ArrayList<>();

        dfs(0, target, path, results, candidates);

        return results;
    }

    private void dfs(int cur, int target, List<Integer> path, List<List<Integer>> results, final int[] candidates) {
        // 剪枝。如果当前和已经大于目标，说明该路径错误，查找中止
        if (target < 0) return;
        else if (target == 0) {
            // 这里要 add 的应该是一个复制的全新 list，而不能把 path 直接加到结果 results 里面去
            results.add(new ArrayList<>(path));
            return;
        } else {
            // 扩展状态。否则，选取之后的每个数字都是一种可能性，对剩余所有可能性进行深度优先搜索
            for (int i = cur; i < candidates.length; i++) {
                // 典型的先加入元素，再进行搜索，递归回来再移出元素的DFS解法
                path.add(candidates[i]);
                // 在调用下一层递归时，查找范围的起始数字不是当前数字而是下一个数字即可
                dfs(i + 1, target - candidates[i], path, results, candidates);
                path.remove(path.size() - 1);

                // 每层扫描的时候跳过重复的 candidates
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumII obj = new CombinationSumII();
        System.out.println(obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
