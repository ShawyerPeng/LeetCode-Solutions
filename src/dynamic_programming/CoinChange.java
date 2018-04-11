package dynamic_programming;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // dp[i]表示凑齐钱数i需要的最少硬币数
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++)
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE)
                    // 用当前的硬币能组合成啥，取最小
                    // dp[i + coins[j] ] = min(dp[i + coins[j] ] , dp[i] + 1）
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static int coinChange2(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;
        // dp[i]表示凑齐钱数i需要的最少硬币数
        int dp[] = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]] + 1);
                }

            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(CoinChange.coinChange2(coins, amount));
    }
}
// 参考：https://www.hrwhisper.me/leetcode-coin-change/
// http://www.cnblogs.com/grandyang/p/5138186.html
// http://blog.csdn.net/qiexingqieying/article/details/51719474