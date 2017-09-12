package sort;

import java.util.Arrays;

public class QuickSort2 {
    public static void quickSort(int[] arr, int start, int end) {
        int i = start;
        int j = end;
        int pivot = arr[start + (end - start) / 2];
        while (i < j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (j > start) {
            quickSort(arr, start, j);
        }
        if (i < end) {
            quickSort(arr, i, end);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 4, 5, 3, 6, 0, 2, 1, 9, 8};
        quickSort(nums,0, 5);
        System.out.println(Arrays.toString(nums));
    }
}
// 参考：https://www.jiuzhang.com/qa/712/