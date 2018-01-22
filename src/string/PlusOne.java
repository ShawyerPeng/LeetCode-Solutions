package string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one
 * 问题：动态数组存了一些个位数字，组成一个大数，计算这个大数加一之后的值。
 * 思路：
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        System.out.println(Arrays.toString(obj.plusOne(new int[]{1, 9, 9})));
    }
}
// http://www.cnblogs.com/grandyang/p/4079357.html
// http://blog.csdn.net/havenoidea/article/details/12839885