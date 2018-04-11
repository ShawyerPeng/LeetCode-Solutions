package array;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii
 */
public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        int res = 0;
        int mid = getMedian(nums);
        // 算每个数与中位数的差的绝对值
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - mid);
        }
        return res;
    }

    private int getMedian(int[] nums) {
        int median = nums.length / 2 + 1;
        //return findKthLargest(nums, median);
        return quickSelect(nums, median, 0, nums.length - 1);
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = partition(nums, left, right);
            if (mid == k - 1) {
                return nums[mid];
            } else if (mid > k - 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    private int partition(int[] nums, int left, int right) {
        Random rand = new Random();
        int index = rand.nextInt(right - left + 1) + left;
        int pivot = nums[index];
        swap(nums, index, left);
        int i = left;
        int j = right;
        while (i <= j) {
            if (i <= j && nums[i] >= pivot) i++;
            if (i <= j && nums[j] <= pivot) j--;
            if (i <= j && nums[i] < pivot && nums[j] > pivot) {
                swap(nums, i++, j--);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int quickSelect(int[] nums, int k, int left, int right) {
        Random rand = new Random();
        int index = rand.nextInt(right - left + 1) + left;
        int pivot = nums[index];
        swap(nums, index, left);
        int i = left;
        int j = right;
        while (i <= j) {
            while (nums[i] < pivot) i++;
            while (nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums, i++, j--);
        }
        if (i - left + 1 > k) return quickSelect(nums, k, left, i - 1);
        if (i - left + 1 == k && i == j) return nums[i];
        return quickSelect(nums, k - j + left - 1, j + 1, right);
    }

    public int minMoves21(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }

    public int minMoves22(int[] nums) {
        //选择中间大小这个步骤有O(n)的算法，我懒得仔细研究，有需求的同学自己研究
        Arrays.sort(nums);
        int sum = 0;
        int median = nums[nums.length / 2];
        for (int num : nums) sum += Math.abs(median - num);
        return sum;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsII obj = new MinimumMovesToEqualArrayElementsII();
        System.out.println(obj.minMoves2(new int[]{1, 2, 3}));
    }
}
