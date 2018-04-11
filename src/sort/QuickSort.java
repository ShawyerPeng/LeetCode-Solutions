package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * http://www.lintcode.com/en/problem/sort-integers-ii/
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private static void quickSortHelper(int[] nums, int left, int right) {
        // 快排区间要大于1
        if (left >= right) return;
        // 确定划分位置，以nums[mid]划分区间为左右两个区间
        int mid = partition(nums, left, right);
        // 对左区间[left...mid-1]进行进一步划分
        quickSortHelper(nums, left, mid - 1);
        // 对右区间[mid+1...right]进行进一步划分
        quickSortHelper(nums, mid + 1, right);
    }

    /**
     * Partition：选择一个元素作为标的点（pivot），将整个数组的所有元素分为小于这个元素和大于这个元素两部分
     */
    private static int partition(int[] nums, int left, int right) {
        // 选数组的第一个作为中轴，循环过程保持 nums[l+1...j] < v ; nums[j+1...i) > v
        int i = left;
        int j = right;
        int pivot = nums[left];

        while (i < j) {
            // 注意：上下两个这个while循环的判断条件中，不能都写成nums[i] < pivot和nums[j] > pivot，也就是必然有一个是=的，否则数组中出现相等的元素会出现死循环
            // 从i开始由前往后搜索(i++)，找到第一个大于pivot的值nums[i]，将nums[j]和nums[i]互换，即把nums[i]移到右边
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            // 比中轴大的记录移到右边
            nums[j] = nums[i];
            // 从j开始由后往前搜索(j--)，找到第一个小于pivot的值nums[j]，将nums[j]和nums[i]互换，即把nums[j]移到左边
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            // 在i之前检索到则将j位置的小值放到i位置
            // 比中轴小的记录移到左边
            nums[i] = nums[j];
        }
        // 中轴记录到尾，跳出while循环后的i==j，此时，区间已经一分为二了，将nums[i]的值还原
        nums[i] = pivot;
        // 返回中轴的位置，这种情况下第一趟结束i的坐标都比它小i的右边都比他大
        return i;
    }

    /**
     * 《算法导论》中的实现。思路是从前往后遍历，每遍历到一个新元素，先进行判断，元素小于pivot的话，把它交给数组的left部分，否则right部分。
     * 具体如何交给left呢？那就是先让left增加，这个时候left部分会持有一个不属于它的元素（>=pivot），这时把这个元素和才遍历到的元素交换就行了；
     * 而如果这个元素本来就属于right部分，则不用做任何处理。
     * 或者你也可以打个比喻，想象一下，假设mid为pivot主元素，j元素为前方开路元素,和pivot进行比较，如果大于主元素则继续开路，如果小于pivot则i元素加1并和j元素交换之后，j元素继续开路直到最后。
     */
    private static int partition2(int[] nums, int left, int right) {
        int i = left - 1;
        int j = left;

        Random random = new Random();
        int index = random.nextInt(right - left + 1) + left;
        int temp = nums[index];
        nums[index] = nums[right];
        nums[right] = temp;
        // 将最后一个元素作为pivot
        int pivot = nums[right];

        // 从第一个元素开始到倒数第二个元素结束，比较确定pivot的位置
        for (; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                // swap
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // 最终确定pivot的位置
        temp = nums[i + 1];
        nums[i + 1] = nums[right];
        nums[right] = temp;

        // 返回pivot的位置
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 4, 5, 3, 6, 0, 2, 1, 9, 8};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
// 参考：https://www.jiuzhang.com/qa/1451/
// http://www.jiuzhang.com/solutions/quick-sort/
// http://www.cnblogs.com/dyllove98/p/3202805.html