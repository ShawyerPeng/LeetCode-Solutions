package hashing;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-duplicate-number
 * 题目：给定一个 n + 1 个数的数组，数组中每个元素的值介于 1~n，假设只有一个元素是重复的，求这个元素
 * 要求：不能改动数组内容、空间复杂度要求O(1)、时间复杂度不超过O(n^2)、只有一个重复数字，但是可能重复超过一次
 * 思路：因为时间复杂度要求要小于 O(n2), 所以不能用朴素的判别。空间复杂度 O(1) 所以不能 hash，不能修改所以不能排序, 可能不止重复一次所以不能 n 项和
 * 方法一：二分
 * <p>
 * 方法二：双指针
 */
public class FindTheDuplicateNumber {
    /**
     * 我们知道，这总共 n + 1 个数每个数 x 都满足  1 <= x <= n
     * 所以，我们二分答案为   mid = (L+R)/2 其中 L=1  R= n
     * 然后扫描整个数组进行统计 ，设 cnt 为满足不大于 mid 的元素个数
     * 则有：cnt <= mid  则说明重复的应该在 [mid , R] ，否则，应该在 [L,mid]
     * 总的时间复杂度为 O(nlogn)
     */
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        if (n < 1) return -1;

        int left = 0, right = n - 1, mid;
        // 在 left==right 终止
        while (left <= right) {
            // 找到中间那个数
            mid = left + (right - left) / 2;
            int count = 0;
            // 计算总数组中有多少个数小于等于中间数
            for (int num : nums) {
                if (num <= mid)
                    count++;
            }
            // 如果小于等于中间数的数量大于中间数，说明前半部分必有重复
            if (count > mid) {
                right = mid - 1;
            }
            // 否则后半部分必有重复
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findDuplicate(nums));
    }
}
// https://segmentfault.com/a/1190000003817671
// http://blog.csdn.net/whiterbear/article/details/49583837
// http://wenzhiquan.github.io/2016/04/14/leetcode_287_hard_find_the_duplicate_number/
// https://boweihe.me/2016/03/30/leetcode-287-find-the-duplicate-number-%E6%99%BA%E5%95%86%E8%A2%AB%E7%A2%BE%E5%8E%8B%EF%BC%81/
// http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/