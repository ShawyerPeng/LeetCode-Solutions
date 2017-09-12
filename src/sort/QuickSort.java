package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] nums) {
        quickSortHelper(0, nums.length - 1, nums);
    }

    private static void quickSortHelper(int left, int right, int[] nums) {
        int partition = partition(left, right, nums);
        if (left < partition - 1) {
            quickSortHelper(left, partition - 1, nums);
        }
        if (right > partition + 1) {
            quickSortHelper(partition + 1, right, nums);
        }
    }

    private static int partition(int left, int right, int[] nums) {
        int pivot = nums[left];
        while (left < right) {
            while (nums[right] >= pivot && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] <= pivot && left < right) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 4, 5, 3, 6, 0, 2, 1, 9, 8};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
// 参考：https://www.jiuzhang.com/qa/1451/
// http://www.jiuzhang.com/solutions/quick-sort/