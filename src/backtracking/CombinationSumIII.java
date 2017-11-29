package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii
 * 问题：
 * 思路：
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dfs(1, n, k, path, results);

        return results;
    }

    private void dfs(int cur, int target, int k, List<Integer> path, List<List<Integer>> results) {
        // 剪枝。如果当前和已经大于目标，说明该路径错误，查找中止
        if (target < 0 || k < 0) return;
        else if (target == 0 && k == 0) {
            // 这里要 add 的应该是一个复制的全新 list，而不能把 path 直接加到结果 results 里面去
            results.add(new ArrayList<>(path));
        } else {
            // 扩展状态。否则，选取之后的每个数字都是一种可能性，对剩余所有可能性进行深度优先搜索
            for (int i = cur; i <= 9; i++) {
                // 典型的先加入元素，再进行搜索，递归回来再移出元素的DFS解法
                path.add(i);
                dfs(i + 1, target - i, k - 1, path, results);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSumIII obj = new CombinationSumIII();
        System.out.println(obj.combinationSum3(3, 7));
        System.out.println(obj.combinationSum3(3, 9));
    }
}
