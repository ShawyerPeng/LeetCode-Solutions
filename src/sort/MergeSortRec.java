package sort;

import java.util.Arrays;

/**
 * 使用递归的方式进行归并排序，所需要的空间复杂度是O(n+logn)
 */
public class MergeSortRec {
    /**
     * 该函数通过递归将数组a不断二分，最终将a拆分为一个个数，每一个数当做一个数组。
     * 在回溯时调用函数merge()，从而将单元素数组（即数字）重新合并为有序数组
     */
    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        // 数组中间位置的下标
        int mid = (left + right) / 2;
        if (left < right) {
            // 先递归处理数组左半段，拆分为单个数字
            mergeSort(nums, left, mid);
            // 再递归处理数组右半段，拆分为单个数字
            mergeSort(nums, mid + 1, right);
            // 合并数字为新的有序数组
            merge(nums, left, mid, right);
        }
    }

    /**
     * 此函数将两个有序数组合并成一个有序数组，这两个数组分别为nums[l...m]和nums[m+1...r]
     * 因为数组有序，合并很简单，只要维护几个指针就可以了
     */
    private static void merge(int[] nums, int left, int mid, int right) {
        // temp数组用于暂存合并的结果，每次递归只开j-i+1大小的数组
        int[] temp = new int[right - left + 1];
        // 左右半边的指针
        int i = left, j = mid + 1;
        // 合并后数组的指针
        int index = 0;

        // 将记录由小到大地放进temp数组
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j])
                temp[index++] = nums[i++];
            else
                temp[index++] = nums[j++];
        }

        // 接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }

        // 将temp数组中的元素写入到待排数组中
        for (int k = 0; k < temp.length; k++) {
            nums[left + k] = temp[k];
        }
    }

    private static void merge2(int[] nums, int left, int mid, int right) {
        // temp数组用于暂存合并的结果，每次递归只开j-i+1大小的数组
        int[] temp = new int[nums.length];
        // 左右半边的指针
        int i = left, j = mid + 1;
        // 合并后数组的指针
        int index = left;

        // 合并两个有序数组到temp数组，升序排列
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        // 接下来两个while循环是为了将剩余的（比另一边多出来的个数）放到temp数组中
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }

        // 将temp数组中的元素重新写入到待排数组nums中
        for (int k = left; k <= right; k++) {
            nums[k] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{25, 10, 7, 19, 3, 48, 12, 17, 56, 30, 21};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
// 参考：http://www.jianshu.com/p/39dd1d9b491d