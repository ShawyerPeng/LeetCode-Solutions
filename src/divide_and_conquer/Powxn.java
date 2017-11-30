package divide_and_conquer;

/**
 * https://leetcode.com/problems/powx-n
 * 问题：求pow(x,n)即x^n
 * 思路：x^n = x^{n/2} * x^{n/2} * x^{n%2}
 * 分：将 n 分成 n/2  直到 n=0 时，返回 1；
 * 治：对 n 为偶数，返回两数相乘的结果，奇数再乘多一个 x；
 * 时间复杂度 O(logn)，空间复杂度 O(1)
 */
public class Powxn {
    public double myPow(double x, int n) {
        if (n < 0) return 1 / divide(x, -n);
        return divide(x, n);
    }

    private double divide(double x, int n) {
        if (n == 0) return 1.0;
        double v = divide(x, n / 2);
        // n是偶数
        if (n % 2 == 0)
            return v * v;
        else
            return v * v * x;
    }

    public static void main(String[] args) {
        Powxn obj = new Powxn();
        System.out.println(obj.myPow(2.00000, 10));
        System.out.println(obj.myPow(2.10000, 3));
        System.out.println(obj.myPow(34.00515, -3));
    }
}
// http://blog.csdn.net/u014654002/article/details/51724274