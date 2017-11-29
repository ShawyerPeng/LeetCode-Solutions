package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k
 * 问题：给定整数数组 nums 和整数 k，寻找和等于 k 的连续子数组的个数。
 * 思路：使用 map 来保存当前数组的求和值，然后每到一个数都将 res 进行更新。
 * 假設 sum(i) 為第一個元素至第 i 個元素的總和。
 * 若 sum(j) + k = sum(i)，則代表從 j+1 ~ i 的和也就是 sum(i) - sum(j) 為 k 。
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));
    }
}
// http://blog.csdn.net/liuchonge/article/details/71158902
// http://www.cnblogs.com/grandyang/p/6810361.html
// http://www.jianshu.com/p/51bcf7f712be