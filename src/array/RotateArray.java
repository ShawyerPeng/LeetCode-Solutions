package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/rotate-array
 * 问题：通过 k 步将一个有着 n 个元素的数组旋转到右侧。
 * 思路：将右边的 k 个元素添加进去，再将左边的 n-k 个元素添加进去。
 * in-place：(1) reverse the array; (2) reverse the first k elements; (3) reverse the last n-k elements.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;
        // 右移偏移量 k 可能比数组长度 len 要大
        if (k > nums.length) k %= nums.length;

        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - k; i < nums.length; ++i)
            list.add(nums[i]);
        for (int i = 0; i < nums.length - k; ++i)
            list.add(nums[i]);

        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray obj = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        obj.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
// http://blog.csdn.net/NoMasp/article/details/50600855