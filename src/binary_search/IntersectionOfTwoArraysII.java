package binary_search;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 */
public class IntersectionOfTwoArraysII {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[]{};

        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) set.add(num);
        }
        int k = 0;
        int[] res = new int[set.size()];
        for (Integer num : set) {
            res[k++] = num;
        }
        return res;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target)
                left = mid;
            else
                right = mid;
        }
        if (nums[left] == target || nums[right] == target) return true;
        return false;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        int results[] = new int[nums1.length];// 结果数组

        // 没有数字的情况
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        // 先对两个数组排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0;
        for (int i = 0, j = 0; i < nums1.length; ) {
            if (nums1[i] < nums2[j]) {// 第一个数组中数字小
                i++;
            } else if (nums1[i] == nums2[j]) {// 数字相同，放入结果数组
                results[index] = nums1[i];
                index++;
                i++;
                // 判断第二个数组有没有到最后一个数组，还没到才继续往后移去比
                if (j < nums2.length - 1) j++;
                else break;
            } else {// 第二个数组中数字小，注意要判断是否到达最后一个数字
                if (j < nums2.length - 1) j++;
                else break;
            }
        }

        return Arrays.copyOfRange(results, 0, index);// 结果数组只返回有数字的那一部分
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII obj = new IntersectionOfTwoArraysII();
        System.out.println(Arrays.toString(obj.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
