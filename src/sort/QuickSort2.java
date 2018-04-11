package sort;

import java.util.Arrays;

public class QuickSort2 {
    public static void quickSort(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int pivot = nums[left + (right - left) / 2];

        // every time you compare left & right, it should be left <= right not left < right
        while (i < j) {
            // 从左往右找到第一个>=pivot的元素
            while (nums[i] < pivot) i++;
            // 从右往左找到第一个<=pivot的元素
            while (nums[j] > pivot) j--;
            if (i <= j) {
                swap(nums, i++, j--);
            }
        }
        if (j > left) quickSort(nums, left, j);
        if (i < right) quickSort(nums, i, right);
    }

    /**
     * https://www.jiuzhang.com/qa/712/
     */
    public static void quickSort2(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = nums[left + (right - left) / 2];
        int i = left;
        int j = right;
        // 保证两个排序的区间不重叠
        while (i <= j) {
            while (i <= j && nums[i] <= pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i <= j) {
                // 为啥必须是小于等于，不能只是小于
                // 因为如果是小于的话，比如left==right的时候，while条件一直成立，所以会tle
                swap(nums, i++, j--);
            }
        }
        System.out.println("[" + left + "," + j + "]     " + "[" + i + "," + right + "]");
        quickSort2(nums, left, j);
        quickSort2(nums, i, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{7, 4, 5, 3, 6, 0, 2, 1, 9, 8};
        int[] nums = new int[]{5, 4, 3, 2};
        quickSort2(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
// 参考：https://www.jiuzhang.com/qa/712/