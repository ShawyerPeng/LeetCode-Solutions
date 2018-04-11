package array;

/**
 * https://leetcode.com/problems/maximum-product-subarray
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            // 最大值和最小值都可能是max*nums[i],min*nums[i]或者nums[i]三种情况
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();
        System.out.println(obj.maxProduct(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
