package hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number
 * 问题：
 * 思路：
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 如果已经在 HashSet 中，则删除
            if (set.contains(num)) {
                set.remove(num);
            } else {
                // 如果不在 HashSet 中，则插入
                set.add(num);
            }
        }

        int result = 0;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            // 最后剩余在HashSet中的就是只出现一次的
            result = (int) it.next();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 7, 8, 8, 7, 1};
        System.out.println(singleNumber(nums));
    }
}
//