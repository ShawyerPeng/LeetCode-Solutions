package dynamic_programming;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // dp[i]表示爬到第i阶楼梯的最小代价
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            // 要到达第i阶楼梯，可以从第i-1层上花cost[i-1]爬一步上来，也可以从第i-2层上花cost[i-2]爬两步上来
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    /**
     * 滚动数组，O(1)的空间复杂度
     */
    public int minCostClimbingStairsO1(int[] cost) {
        int n = cost.length;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i <= n; i++) {
            int dp = Math.min(dp1 + cost[i - 1], dp2 + cost[i - 2]);
            dp2 = dp1;
            dp1 = dp;
        }
        // 因为dp1是最后的dp
        return dp1;
    }

    public int minCostClimbingStairs0(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairs1(int[] cost) {
        int m[] = new int[cost.length + 1];
        return dp1(cost, m, cost.length);
    }

    private int dp1(int[] cost, int[] m, int i) {
        // 在第0阶或第1阶开始爬是不需要代价的
        if (i <= 1) return 0;
        // 已求解过子问题，直接返回
        if (m[i] > 0) return m[i];
        return m[i] = Math.min(dp1(cost, m, i - 1) + cost[i - 1],
                dp1(cost, m, i - 2) + cost[i - 2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int m[] = new int[cost.length + 1];
        return Math.min(dp2(cost, m, cost.length - 1),
                dp2(cost, m, cost.length - 2));
    }

    private int dp2(int[] cost, int[] m, int i) {
        if (i < 0) return 0;
        if (m[i] > 0) return m[i];
        return m[i] = Math.min(dp2(cost, m, i - 1), dp2(cost, m, i - 2)) + cost[i];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs obj = new MinCostClimbingStairs();
        System.out.println(obj.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(obj.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
