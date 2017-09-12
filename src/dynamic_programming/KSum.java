package dynamic_programming;

public class KSum {
    public static int kSum(int[] nums, int k, int target) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        // 前 i 个数字，取其中 j 个，其和为 t 的方案数量
        // dp[i][j][t]表示从0遍历到nums[i]后找到的j个元素之和为t的情况的总数
        int[][][] dp = new int[n + 1][k + 1][target + 1];

        for (int i = 0; i <= n; i++) dp[i][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    dp[i][j][t] = dp[i - 1][j][t];
                    // 如果
                    if (nums[i - 1] <= t) {
                        dp[i][j][t] = dp[i-1][j][t] + dp[i - 1][j - 1][t - nums[i - 1]];
                    }
                }
            }
        }
        return dp[n][k][target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int k = 2;
        int target = 5;
        System.out.println(KSum.kSum(nums, k, target));
    }
}
// 参考：https://pobenliu.gitbooks.io/leetcode/k%20Sum.html
// https://segmentfault.com/a/1190000004984393
// http://lifexplorer.me/leetcode-3sum-4sum-and-k-sum/