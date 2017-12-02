package hashing;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index
 * 问题：
 * 思路：解法 I：O(n) 统计 + 遍历
 * 使用长度为 N + 1 的数组 cnts 记录引用次数在 0 ~ N（N 篇以上的记为 N）的文章个数
 * 然后遍历 cnts 数组，计算 h 值的最大值
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int[] stats = new int[citations.length + 1];
        int n = citations.length;
        // 统计各个引用次数对应多少篇文章
        for (int i = 0; i < n; i++) {
            stats[citations[i] <= n ? citations[i] : n] += 1;
        }
        int sum = 0;
        // 找出最大的H指数
        for (int i = n; i > 0; i--) {
            // 引用大于等于i次的文章数量，等于引用大于等于i+1次的文章数量，加上引用等于i次的文章数量
            sum += stats[i];
            // 如果引用大于等于i次的文章数量，大于引用次数i，说明是H指数
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex obj = new HIndex();
        System.out.println(obj.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
// https://segmentfault.com/a/1190000003794831
// http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51593843
// http://blog.csdn.net/liuchonge/article/details/58596641