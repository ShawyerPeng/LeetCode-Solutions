package math;

/**
 * https://leetcode.com/problems/power-of-three
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int num) {
        return (Math.log(num) / Math.log(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        PowerOfThree obj = new PowerOfThree();
        System.out.println(obj.isPowerOfThree(9));
        System.out.println(obj.isPowerOfThree(8));
    }
}
