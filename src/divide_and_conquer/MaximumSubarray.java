package divide_and_conquer;

/**
 * https://leetcode.com/problems/maximum-subarray
 * 问题：求连续的数组值，加和最大。
 * 思路：将数组均分为两个部分，那么最大子数组会存在于：
 * 左侧数组的最大子数组
 * 右侧数组的最大子数组
 * 左侧数组的以右侧边界为边界的最大子数组 + 右侧数组的以左侧边界为边界的最大子数组
 */
public class MaximumSubarray {
    public int maxSubnumsrray(int[] nums) {
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
        System.out.println(obj.maxSubnumsrray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
// http://www.cnblogs.com/springfor/p/3877058.html
// https://www.tianmaying.com/tutorial/LC53