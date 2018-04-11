package two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.lintcode.com/en/problem/subarray-sum/
 */
public class SubarraySum {
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        // 保存前i个元素的和与索引i的映射
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        // 先存入一个，这样可以考虑到起始索引为0的情况
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 如果sum已经存在了，说明该位置和上次位置之间的元素和为零
            if (map.containsKey(sum)) {
                results.add(map.get(sum) + 1);
                results.add(i);
                break;
            } else map.put(sum, i);
        }
        return results;
    }

    public static void main(String[] args) {
        SubarraySum obj = new SubarraySum();
        System.out.println(obj.subarraySum(new int[]{-3, 1, 2, -3, 4}));
    }
}
