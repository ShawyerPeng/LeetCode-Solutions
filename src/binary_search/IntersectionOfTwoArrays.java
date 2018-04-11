package binary_search;

import java.util.Arrays;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays
 */
public class IntersectionOfTwoArrays {
    /**
     * 复杂度：time-O(nlogn), space-O(n)
     */
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

    /**
     * 复杂度：time-O(nlogn), space-O(1)
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[]{};

        HashSet<Integer> set = new HashSet<>();
        // 对两个数组都进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 双指针查找
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        // 输出结果
        int k = 0;
        int[] res = new int[set.size()];
        for (Integer num : set) {
            res[k++] = num;
        }
        return res;
    }

    /**
     * 复杂度：time-O(n), space-O(n)
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[]{};

        // set存nums1中所有不重复的数，ret存返回结果
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ret = new HashSet<>();
        for (Integer num : nums1) {
            set.add(num);
        }
        for (Integer num : nums2) {
            if (set.contains(num)) ret.add(num);
        }
        int k = 0;
        int[] res = new int[set.size()];
        for (Integer num : set) {
            res[k++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArrays obj = new IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(obj.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
