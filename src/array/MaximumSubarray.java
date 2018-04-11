package array;

/**
 * https://leetcode.com/problems/maximum-subarray
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * DP
     */
    public int maxSubArray2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //dp[i] = nums[i] + (dp[i - 1] < 0 ? 0 : dp[i - 1]);
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * Divide and Conquer
     */
    public int maxSubArray3(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int nums[], int left, int right) {
        // 如果只有一个元素了，直接返回该元素（终止条件）
        if (left == right) return nums[left];
        if (left == right - 1) return Math.max(nums[left] + nums[right], Math.max(nums[left], nums[right]));

        int mid = left + (right - left) / 2;
        // 分治
        int lmax = divide(nums, left, mid - 1);
        int rmax = divide(nums, mid + 1, right);

        int mmax = nums[mid];
        int tmp = mmax;
        // 不断往左比较，如果加上nums[i]后子数组的和tmp大于mmax，则更新
        for (int i = mid - 1; i >= left; i--) {
            tmp += nums[i];
            if (tmp > mmax)
                mmax = tmp;
        }
        tmp = mmax;
        // 不断往右比较，如果加上nums[i]后子数组的和tmp大于mmax，则更新
        for (int i = mid + 1; i <= right; i++) {
            tmp += nums[i];
            if (tmp > mmax)
                mmax = tmp;
        }

        // 取三者的最大值
        return Math.max(mmax, Math.max(lmax, rmax));
    }

    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(obj.maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(obj.maxSubArray3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}