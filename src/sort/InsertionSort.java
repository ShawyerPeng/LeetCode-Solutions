package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void selectSort(int[] nums) {
        // 将下标为1—n-1的元素逐个插入到已排序序列的适当位置
        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            int temp = nums[i];
            for (j = i; (j > 0) && (temp < nums[j - 1]); j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }

    public static void selectSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                --j;
            }
            nums[j + 1] = temp;
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] a = {7, 4, 5, 3, 6, 0, 2, 1, 9, 8};
        InsertionSort.selectSort2(a);
        System.out.println(Arrays.toString(a));
    }
}
// 参考：http://www.voidcn.com/article/p-tbudabuy-bnu.html