package dynamic_programming;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 前面的数比第i个数小，满足递增条件
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int max = 0;

        for (int i = 1; i < n; i++) {
            int maxval = 0;
            for (int j = 1; j < i; j++) {
                // 前面的数比第i个数小，满足递增条件
                if (nums[j] < nums[i]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(LongestIncreasingSubsequence.lengthOfLIS(nums));
    }
}
// 参考：http://www.jiuzhang.com/solution/longest-increasing-subsequence/
// http://www.cnblogs.com/grandyang/p/4938187.html
// https://www.zhihu.com/question/22001141