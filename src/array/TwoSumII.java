package array;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
 * 问题：数组有序
 * 思路：双指针法
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2) return result;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSumII obj = new TwoSumII();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(obj.twoSum(nums, 9)));
    }
}