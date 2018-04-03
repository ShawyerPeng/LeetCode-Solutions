package divide_and_conquer;

/**
 * https://leetcode.com/problems/sqrtx
 * 问题：
 * 思路：
 */
public class Sqrtx {
    /**
     * Newton's method
     */
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int i = 0, j = x, mid = (i + j) / 2;

        while (i != mid) {
            // 这样表达不会溢出
            if (x / mid < mid)
                j = mid;
            else
                i = mid;
            mid = (i + j) / 2;

        }
        return mid;
    }

    private int divide(int x) {
        return 0;
    }

    /**
     * 二分法，取到合适的数为止。
     * 因为 mid 为 int 类型，所以 mid*mid 是有可能溢出的，应该声明为 long long 类型。
     * 如果限定只能用 int 类型，那么可以将 mid*mid<x 写成 mid<x/mid ，这样肯定不会溢出
     */
    public int mySqrt2(int x) {
        if (x < 2) return x;
        double begin = 0, end = x, mid = 1, res = 0;
        while (Math.abs(res - x) > 0.000001) {
            mid = (begin + end) / 2;
            res = mid * mid;
            if (res > x)
                end = mid;
            else
                begin = mid;
        }
        return (int) mid;
    }

    public int mySqrt3(int x) {
        if (x < 2) return x;
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right;
    }

    public static void main(String[] args) {
        Sqrtx obj = new Sqrtx();
        System.out.println(obj.mySqrt(4));
        System.out.println(obj.mySqrt(8));
    }
}
