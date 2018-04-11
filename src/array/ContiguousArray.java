package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contiguous-array
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1) ? 1 : -1;
            if (map.containsKey(sum)) {
                result = Math.max(result, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContiguousArray obj = new ContiguousArray();
        System.out.println(obj.findMaxLength(new int[]{0, 1, 0}));
    }
}
