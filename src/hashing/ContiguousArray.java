package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array
 * 问题：给定一个二进制的数组，让我们找邻近的子数组使其 0 和 1 的个数相等
 * 思路：
 */
public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
    }
}
// https://kingsfish.github.io/2017/07/13/Leetcode-525-Contiguous-Array/
// http://www.cnblogs.com/grandyang/p/6529857.html
// http://blog.csdn.net/liuchonge/article/details/60351645