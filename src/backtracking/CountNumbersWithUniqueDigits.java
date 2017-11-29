package backtracking;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits
 * 问题：找一个n位长度范围内的各位上都不相同的数字。比如 123 就是各位不相同的数字，而 11,121,222 就不是
 * 思路：
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;

        int count = 10;
        int product = 9;
        for (int i = 1; i < n && i <= 9; i++) {
            product *= 10 - i;
            count += product;
        }
        return count;
    }

    public static void main(String[] args) {
        CountNumbersWithUniqueDigits obj = new CountNumbersWithUniqueDigits();
        System.out.println(obj.countNumbersWithUniqueDigits(2));
        System.out.println(obj.countNumbersWithUniqueDigits(3));
        System.out.println(obj.countNumbersWithUniqueDigits(4));
    }
}
// http://www.jianshu.com/p/8fa9fc9a46ed
// https://www.hrwhisper.me/leetcode-count-numbers-unique-digits/