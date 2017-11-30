package bit_manipulation;

/**
 * https://leetcode.com/problems/super-pow
 * 问题：
 * 思路：不会做...
 */
public class SuperPow {
    private int mod = 1337;

    public int superPow(int a, int[] b) {
        int n = b.length;
        int ans = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans = ans * quick_pow(a, b[i]) % mod;
            a = quick_pow(a, 10);
        }
        return ans;
    }

    int quick_pow(int a, int b) {
        int ans = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) != 0) ans = ans * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return ans;

    }

    public static void main(String[] args) {
        SuperPow obj = new SuperPow();
        System.out.println(obj.superPow(2, new int[]{3}));
        System.out.println(obj.superPow(2, new int[]{1, 0}));
    }
}
// https://www.hrwhisper.me/leetcode-super-pow/
// http://blog.csdn.net/jackzhang_123/article/details/78173474