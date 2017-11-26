package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii
 * 问题：给定一个整数数组 nums 与一个整数 k，当且仅当存在两个不同的下标 i 和 j 满足 nums[i] = nums[j] 并且 |i-j| <= k 时返回 true，否则返回 false。
 * 思路：如果表中不存在则添加该数字的索引，否则计算找到的索引与此前记录索引的记录，是否小于等于 K
 */
public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;

        // key=int, val=index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int j = map.get(nums[i]);
                if (i - j <= k) {
                    return true;
                } else {
                    map.remove(nums[j]);
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{-1, -1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }
}
// http://blog.csdn.net/xudli/article/details/46236267
// http://www.cnblogs.com/grandyang/p/4539680.html