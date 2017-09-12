package dynamic_programming;

import java.util.Arrays;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int n = nums.length;
        // 利用一个dp数组，记录每一轮sum的最大值
        int[] dp = new int[n + 1];

        // 初始化
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // dp[i]表示当前这个元素是跟之前数组加和一组还是自己单立一组好
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(MaximumSubarray.maxSubArray(nums));
    }
}
// 参考：http://www.cnblogs.com/springfor/p/3877058.html