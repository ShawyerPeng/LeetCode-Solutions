package sort;

import java.util.Arrays;

/**
 * 冒泡排序法
 * 原理：
 */
public class BubbleSort {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            // 比较 length-1 趟
            for (int j = 0; j < i; j++) {
                // 比较相邻数字大小
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 4, 5, 3, 6, 0, 2, 1, 9, 8};
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
// http://www.cnblogs.com/wxisme/p/5243631.html