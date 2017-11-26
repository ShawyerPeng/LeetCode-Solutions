package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays
 * 问题：求两个数组的交集，结果无重复
 * 思路：HashMap
 */
public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 统计nums1数组中数字出现的次数
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (map.containsKey(num) && !results.contains(num)) {
                results.add(num);
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
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
