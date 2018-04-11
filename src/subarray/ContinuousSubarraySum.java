package subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) return false;
        // 保存sum对k取余数和当前位置之间的映射
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 余数（注意处理k为0的情况）
            int surplus = (k == 0) ? sum : sum % k;
            // 如果余数已经存在，说明中间一段子数组之和是k的倍数
            if (map.containsKey(surplus)) {
                if (i - map.get(surplus) > 1) return true;
            } else {
                map.put(surplus, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum obj = new ContinuousSubarraySum();
        System.out.println(obj.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(obj.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }
}
