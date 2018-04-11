package bit_manipulation;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/missing-number
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }

    public int missingNumber2(int[] nums) {
        // 等差数列的求和公式 (首项+末项)*项数/2
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            actualSum += nums[i];
        }
        return expectedSum - actualSum;
    }

    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int min = 0, max = nums.length - 1;
        while (min < max) {
            int mid = (min + max) / 2;
            // 没错位，在右边。有错位，则在左边
            if (mid == nums[mid]) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        // 如果没有错位，则返回最后一个数加1
        return nums[min] == min ? min + 1 : min;
    }

    public static void main(String[] args) {
        MissingNumber obj = new MissingNumber();
        System.out.println(obj.missingNumber2(new int[]{0, 1, 2, 7, 4, 3, 5}));
    }
}
