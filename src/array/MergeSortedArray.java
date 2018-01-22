package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array
 * 问题：让 nums2 merge 到 nums1 里面
 * 思路：自尾部向首部逐个比较两个数组内的元素，取较大的置于新数组尾部元素中。
 * merge 后的数组一共有 m+n 个数。i, j 从 A, B 尾部扫描，选 max(A[i], B[j]) 插入从 m+n 起的尾部。
 * 这样也可以防止插入到 A 原来数字的范围内时，overwrite 掉 A 原来的数。
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        // 只剩下nums1或nums2中的一个数组为空
        while (i >= 0) {
            nums1[index--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[index--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4};
        int[] nums2 = new int[]{2, 4, 5, 6};
        MergeSortedArray obj = new MergeSortedArray();
        obj.merge(nums1, 4, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }
}
// http://bangbingsyb.blogspot.com/2014/11/leetcode-merge-sorted-array.html