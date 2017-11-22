package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/single-number-ii
 * 时间复杂度O(n),空间复杂度O(n)
 */
public class SingleNumberII {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 如果不在 HashMap 中，则插入
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else if (map.get(num) < 3) {
                // 如果已经在 HashMap 中，则次数+1
                map.put(num, map.get(num) + 1);
            }
        }

        int result = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if ((Integer) entry.getValue() == 1) {
                result = (Integer) entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 3, 3};
        System.out.println(singleNumber(nums));
    }
}