package dynamic_programming;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        // 初始条件：一级楼梯是一种解法，两级楼梯是两种解法
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 可以从第i-1层阶梯过来，也可以从第i-2层阶梯过来，那么到达第i层阶梯的方法数是两个的和
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(8));
    }
}
