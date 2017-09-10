package array;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k] == 0) {
                        List<Integer> temp = new LinkedList<>();
                        temp.add(i);temp.add(j);temp.add(k);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        ThreeSum prob = new ThreeSum();
        System.out.println(prob.threeSum(nums));
    }
}
