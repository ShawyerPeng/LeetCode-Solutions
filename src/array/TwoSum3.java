package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 用目标数去减当前数，如果所得依然在数组中，那就得到结果
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum3 prob = new TwoSum3();
        System.out.println(Arrays.toString(prob.twoSum(nums, 9)));
    }
}
