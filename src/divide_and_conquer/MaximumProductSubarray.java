package divide_and_conquer;

/**
 * https://leetcode.com/problems/maximum-product-subarray
 * 问题：最大子数组乘积
 * 思路：
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int nums[], int left, int right) {
        return 0;
    }

    public static void main(String[] args) {
        MaximumProductSubarray obj = new MaximumProductSubarray();
        System.out.println(obj.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
// http://blog.csdn.net/whuwangyi/article/details/39577455