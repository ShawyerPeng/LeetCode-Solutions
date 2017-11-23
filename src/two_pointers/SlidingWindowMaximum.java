package two_pointers;

import java.util.TreeMap;

/**
 * Created by ShawyerPeng on 2017/11/23.
 */
public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //int left = 0, right = 0;
        //int max = Integer.MIN_VALUE;
        //while (right < nums.length) {
        //
        //}

        if (k <= 0) return new int[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k - 1; i++) {
            Integer count = map.get(nums[i]);
            if (count == null) count = 1;
            else count++;
            map.put(nums[i], count);
        }
        // System.out.println(map);
        int[] max = new int[nums.length - k + 1];
        for (int i = 0, j = k - 1; j < nums.length; i++, j++) {
            Integer count = map.get(nums[j]);
            if (count == null) count = 1;
            else count++;
            map.put(nums[j], count);
            max[i] = map.lastKey();
            count = map.get(nums[j - k + 1]);
            count--;
            if (count == 0) map.remove(nums[j - k + 1]);
            else map.put(nums[j - k + 1], count);
            // System.out.println(map);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(nums, 3));
    }
}
