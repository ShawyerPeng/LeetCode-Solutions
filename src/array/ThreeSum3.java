package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;

        Arrays.sort(nums);
        HashSet<ArrayList<Integer>> hs = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // 选定 nums[i] 为第一个数，并去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int high = nums.length - 1;

            // 因为两个数不能重复，所以low!=high
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);

                    if (!hs.contains(temp)) {
                        hs.add(temp);
                        res.add(temp);
                    }

                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1])//remove dupicate
                        low++;
                    while (low < high && nums[high] == nums[high + 1])//remove dupicate
                        high--;
                } else if (sum < 0) low++;
                else high--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        ThreeSum3 prob = new ThreeSum3();
        System.out.println(prob.threeSum(nums));
    }
}
// 参考：http://www.cnblogs.com/springfor/p/3859670.html