package array;

import java.util.*;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum
 * 问题：给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * 思路：
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) return results;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    results.add(temp);
                    left++;
                    right--;
                    // 跳过重复的值
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return results;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) return results;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            twoSum(nums, left, right, target, results);
        }
        return results;
    }

    private void twoSum(int[] nums, int left, int right, int target, List<List<Integer>> results) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(-target);
                temp.add(nums[left]);
                temp.add(nums[right]);
                results.add(temp);
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        ThreeSum prob = new ThreeSum();
        System.out.println(prob.threeSum2(nums));

        Map<String, Integer> map = new HashMap<>();
        Integer a = 2;
        map.put("a", a);
        System.out.println(map.get("a"));
        a = 1;
        System.out.println(map.get("a"));
    }
}
// https://pobenliu.gitbooks.io/leetcode/3%20Sum.html