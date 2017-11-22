package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/set-mismatch
 * 问题：
 * 思路：用 sum 来做
 */
public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int sum = (n * (n + 1)) / 2;
        int[] results = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sum -= num;
            } else {
                results[0] = num;
            }
        }
        results[1] = sum;
        return results;
    }

    /**
     * 用一个 map，第一遍循环，把 set S 过一遍，出现的数字用 map 标记，同时记录下重复的数字（已标记过的数字第二次读到为重复数字）。
     * 第二遍循环，把 map 过一遍，查找缺失数字（没有被标记的数字）。
     * 时间复杂度为 o(n)。
     */
    public static int[] findErrorNums2(int[] nums) {
        int res[] = new int[2];
        // boolean类型默认初始化为false
        boolean map[] = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            if (map[nums[i]] == false) map[nums[i]] = true;
            else res[0] = nums[i];
        for (int i = 1; i < (nums.length + 1); i++)
            if (map[i] == false) {
                res[1] = i;
                break;
            }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(findErrorNums2(nums)[0] + " " + findErrorNums2(nums)[1]);
    }
}
// http://www.voidcn.com/article/p-krzfysst-bmq.html