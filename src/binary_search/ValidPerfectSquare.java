package binary_search;

/**
 * https://leetcode.com/problems/valid-perfect-square
 * 问题：
 * 思路：
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;

        long left = 0;
        long right = num;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            long temp = mid * mid;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num && (mid + 1) * (mid + 1) > num)
                return false;
            else if (temp < num)
                left = mid;
            else if (temp > num)
                right = mid;
        }
        if (left * left == num || right * right == num) return true;
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare obj = new ValidPerfectSquare();
        System.out.println(obj.isPerfectSquare(16));
        System.out.println(obj.isPerfectSquare(14));
        System.out.println(obj.isPerfectSquare(9));
    }
}
