package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        // 它的左边全是0(red)
        int red = 0;
        // 它的右边全是2(blue)
        int blue = nums.length - 1;
        // 当前指针
        int index = 0;
        while (index <= blue) {
            if (nums[index] == 0) {
                // 如果当前index元素是0(red)，那么0将被交换到red位置
                // 由于交换过后index指向的元素是之前已经遍历过了的，所以index++
                swap(nums, index++, red++);
            } else if (nums[index] == 1) {
                // 如果当前index元素是1(white)，不做处理，index移动到下一个
                index++;
            } else {
                // 如果当前index元素是2(blue)，那么2将被交换到blue位置
                // 由于交换过后index指向的元素是0是1都有可能，所以index不变，还要比较一次
                swap(nums, index, blue--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors obj = new SortColors();
        int[] nums = new int[]{1, 0, 2, 2, 1, 0, 1, 2, 0, 1, 0, 1};
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}