package math;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes
 * 问题：
 * 思路：
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes obj = new FactorialTrailingZeroes();
        System.out.println(obj.trailingZeroes(2147483647));
    }
}