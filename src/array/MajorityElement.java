package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                result = num;
                break;
            }
        }
        return result;
    }

    /**
     * Moore Voting Algorithm
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        int result = 0;
        for (int num : nums) {
            if (count == 0) result = num;
            if (num != result)
                count--;
            else
                count++;
        }
        return result;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        System.out.println(obj.majorityElement3(new int[]{1, 4, 5, 2, 3, 4, 4, 4, 4}));
    }
}
