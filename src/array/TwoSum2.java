package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum2 prob = new TwoSum2();
        System.out.println(Arrays.toString(prob.twoSum(nums, 9)));
    }
}
