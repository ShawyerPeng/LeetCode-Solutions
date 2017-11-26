package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate
 * 问题：给定一个数组，判断是否包含重复值
 * 思路：使用一个哈希表，遍历整个数组，如果哈希表里存在，返回 false，如果不存在，则将其放入哈希表中
 */
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else if (map.get(num) >= 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9};
        System.out.println(containsDuplicate(nums));
    }
}
