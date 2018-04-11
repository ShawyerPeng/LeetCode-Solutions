package dynamic_programming;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        // 初始条件：一级楼梯是一种解法，两级楼梯是两种解法
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 可以从第i-1层阶梯过来，也可以从第i-2层阶梯过来，那么到达第i层阶梯的方法数是两个的和
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        int result = 0;
        int num1 = 0, num2 = 1;
        for (int i = 1; i <= n; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }

    public static int climbStairsRec(int n) {
        if (n <= 2) return n;
        else return climbStairsRec(n - 1) + climbStairsRec(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(8));
        System.out.println(climbStairsRec(8));
    }
}