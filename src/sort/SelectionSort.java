package sort;

import java.util.Arrays;

/**
 * 选择排序法
 * 原理：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。
 * 时间复杂度：O(n^2)。简单选择排序的比较次数与序列的初始排序无关。 假设待排序的序列有 N 个元素，则比较次数永远都是 N (N - 1) / 2。
 * 而移动次数与序列的初始排序有关。当序列正序时，移动次数最少，为 0。当序列反序时，移动次数最多，为 3N (N - 1) /  2。
 * 空间复杂度：O()
 */
public class SelectionSort {
    public static void selectSort(int[] nums) {
        // 做第i趟排序
        for (int i = 0; i < nums.length - 1; i++) {
            // 将当前下标定义为最小值下标
            int min = i;
            // 选最小的记录
            for (int j = i + 1; j < nums.length; j++) {
                // 从小到大排序
                if (nums[j] < nums[min]) {
                    // 如果有小于当前最小值的关键字将此关键字的下标赋值给flag（目前找到的最小值所在的位置）
                    min = j;
                }
            }
            // 在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != min) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 7, 4, 9, 6, 3, 4, 0, 10};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
// https://www.cnblogs.com/shen-hua/p/5424059.html