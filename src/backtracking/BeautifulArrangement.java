package backtracking;

/**
 * https://leetcode.com/problems/beautiful-arrangement
 * 问题：所谓美丽的排布是指，在i位置上的数字能够整除i或者被i整除，i从 1 开始。给定一个数字N，计算有多少个这样的排布。
 * 思路：
 */
public class BeautifulArrangement {
    public int countArrangement(int N) {
        if (N == 0 || N == 1) return N;
        // 表示这个排布中的某一个数字（用数组下标表示）是否被使用，因为从1开始，所以数组的长度为N+1
        int[] used = new int[N + 1];
        return dfs(1, N, used);
    }

    private int dfs(int index, int N, int[] used) {
        if (index > N) return 1;

        int count = 0;
        // 先从第 1 个位置找合适的数字，如果数字合适然后这个数字没有被使用则将used数组对应下标设为已使用，以此类推
        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (index % i == 0 || i % index == 0)) {
                // 标记为已使用
                used[i] = 1;
                count += dfs(index + 1, N, used);
                // 回溯的时候只需要将前面使用的标记为未使用就可以了
                used[i] = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BeautifulArrangement obj = new BeautifulArrangement();
        System.out.println(obj.countArrangement(2));
    }
}
// http://blog.jerkybible.com/2017/02/28/LeetCode-526-Beautiful-Arrangement/
// http://www.cnblogs.com/grandyang/p/6533276.html