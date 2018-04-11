package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) return results;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 选定 nums[i] 为第一个数，并去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int high = nums.length - 1;

            // 因为两个数不能重复，所以low!=high
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    // 防止重复解
                    while (low < high && nums[low] == nums[low - 1]) low++;
                    while (low < high && nums[high] == nums[high + 1]) high--;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        ThreeSum2 prob = new ThreeSum2();
        System.out.println(prob.threeSum(nums));
    }
}
