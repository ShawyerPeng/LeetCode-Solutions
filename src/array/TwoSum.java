package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum
 * 问题：给定一个数组，和目标值，求数组里两个数的和等于目标值的下标，数组里数不重复。
 * 思路：
 */
public class TwoSum {
    /**
     * 哈希法
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 用目标数去减当前数，如果所得依然在数组中，那就得到结果
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                result[0] = map.get(complement);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * 双指针法
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) return res;

        // 复制原始数组并排序
        int[] copylist = new int[nums.length];
        System.arraycopy(nums, 0, copylist, 0, nums.length);
        Arrays.sort(copylist);

        // 设置 low 和 high 指针
        int low = 0;
        int high = copylist.length - 1;

        // 二分查找法，判断 target 和 nums[low]+nums[high]哪个大
        while (low < high) {
            if (copylist[low] + copylist[high] < target)
                low++;
            else if (copylist[low] + copylist[high] > target)
                high--;
            else {
                res[0] = copylist[low];
                res[1] = copylist[high];
                break;
            }
        }

        // 把找到的两个合格值在原 list 中找到对应的 index
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == res[0] && index1 == -1)
                index1 = i + 1;
            else if (nums[i] == res[1] && index2 == -1)
                index2 = i + 1;
        }
        res[0] = index1;
        res[1] = index2;
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(obj.twoSum(nums, 9)));
    }
}
// http://www.cnblogs.com/springfor/p/3859618.html