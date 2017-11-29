package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum
 * 问题：给定无重复元素数组candidates和目标数target，求所有的组合使元素之和等于target，元素可以重复相加。
 * 思路：穷举出符合条件的组合，我们一般考虑 dfs。
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return results;

        // 先将candidate数组排序避免重复搜索，为后面的剪枝做准备
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
                // 如果选定一个 candidates[i]，则需要继续寻找和为 target-candidate[i] 的 combination
                // 因為C中每个数可以选多次，所以从i開始，而不是i+1
                dfs(i, target - candidates[i], path, results, candidates);
                path.remove(path.size() - 1);

                // 每层扫描的时候跳过重复的 candidates
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) i++;
                //if (i > cur && candidates[i] == candidates[i - 1]) continue;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
// https://segmentfault.com/a/1190000003743112
// https://www.hrwhisper.me/leetcode-recursive-or-dfs/
// http://blog.csdn.net/linhuanmars/article/details/20828631