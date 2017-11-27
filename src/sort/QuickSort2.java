package sort;

import java.util.Arrays;

public class QuickSort2 {
    public static void quickSort(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        // pivot is the value, not the index
        int pivot = arr[start + (end - start) / 2];

        // every time you compare left & right, it should be
        // left <= right not left < right
        while (left < right) {
            // A[left] < pivot not A[left] <= pivot
            while (arr[left] < pivot) {
                left++;
            }
            // A[right] > pivot not A[right] >= pivot
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        if (right > start) {
            quickSort(arr, start, right);
        }
        if (left < end) {
            quickSort(arr, left, end);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 4, 5, 3, 6, 0, 2, 1, 9, 8};
        quickSort(nums, 0, 5);
        System.out.println(Arrays.toString(nums));
    }
}
// 参考：https://www.jiuzhang.com/qa/712/