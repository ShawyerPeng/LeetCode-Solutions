package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations
 * 问题：给定两个数 n,k，从 1...n 这 n 个数中选择 k 个组成一个组合（不能重复）
 * 思路：
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        if (k == 0 || n < k) return results;

        dfs(0, n, k, new ArrayList<>(), results);

        return results;
    }

    private void dfs(int start, int n, int k, List<Integer> path, List<List<Integer>> results) {
        if (k < 0) return;
        else if (k == 0) {
            // k==0 表示已经找到了 k 个数字的组合，这时候加入 result 中
            results.add(new ArrayList<>(path));
        } else {
            // start 是 i 的起点。为什么要加入它呢？比如我们第一次加入了 1，下一次搜索的时候还能再搜索 1 了么？肯定不可以啊！
            // 我们必须从他的下一个数字开始，也就是 2 、3 或者 4 啦。所以 start 就是一个开始标记这个很重要啦！
            for (int i = start; i <= n; i++) {
                // 尝试性的加入 i
                path.add(i);
                // 下一次的start是数组的下一个值
                dfs(i + 1, n, k - 1, path, results);
                // 回退到上一步
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        System.out.println(obj.combine(4, 2));
    }
}
// http://blog.csdn.net/u013215018/article/details/72677276
// http://www.caesium.space/2017/03/12/Leetcode-77-Combination