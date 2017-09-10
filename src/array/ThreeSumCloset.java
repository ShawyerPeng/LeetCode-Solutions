package array;

import java.util.Arrays;

public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];

        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                if (sum < target) low++;
                else high--;

                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        ThreeSumCloset prob = new ThreeSumCloset();
        System.out.println(prob.threeSumClosest(nums, target));
    }
}
