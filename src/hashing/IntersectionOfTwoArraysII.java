package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 */
public class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 统计nums1数组中数字出现的次数
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num)) {
                results.add(num);
                if (map.get(num) == 1) map.remove(num);
                else if (map.get(num) > 1) map.put(num, map.get(num) - 1);
            }
        }

        int[] res = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            res[i] = results.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
        nums1 = new int[]{1};
        nums2 = new int[]{1, 1};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }
}
