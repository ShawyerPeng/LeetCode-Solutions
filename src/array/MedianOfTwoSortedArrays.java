package array;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays
 * 问题：
 * 思路：
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) return findMedianSortedArrays(nums2, nums1);

        int k = (n1 + n2 + 1) / 2;
        int left = 0;
        int right = n1 - 1;

        // 二分查找 [l,r) 左闭右开
        while (left < right) {
            // 在第一个数组中使用m1个元素，在第二个数组中使用m2个元素
            int m1 = left + (right - left) / 2;
            int m2 = k - m1;
            // 第一个数组的元素不够多，那么left=m1+1
            if (nums1[m1] < nums2[m2 - 1])
                left = m1 + 1;
            else
                right = m1 - 1;
        }

        // m1表示数组一中用到的个数，m2表示数组二中用到的个数
        int m1 = left;
        int m2 = k - left;

        // 左中位数取两个数组中的较大数
        // 如果m1<=0，表示第一个数组完全没有使用，要考虑这种边界情况；m2同理
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);

        // 如果两个数组总共为奇数个，直接返回c1
        if ((n1 + n2) % 2 == 1) return c1;

        // 右中位数取两个数组中的较小数
        // 如果m1>=n1，表示第一个数组已经越界了，要考虑这种边界情况；m2同理
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);

        // 如果两个数组总共为偶数个，直接返回左中位数和有中位数的平均值
        return (c1 + c2) * 0.5;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(obj.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

    }
}
// http://blog.csdn.net/yutianzuijin/article/details/11499917