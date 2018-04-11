package bit_manipulation;

/**
 * https://leetcode.com/problems/power-of-four
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        while (num % 4 == 0) {
            num /= 4;
        }
        // 如果num是4的次幂，那么一定能被4除尽，最后结果为1
        return num == 1;
    }

    public boolean isPowerOfFour2(int num) {
        // log_10^16 / log_10^4 == 4
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }

    public static void main(String[] args) {
        PowerOfFour obj = new PowerOfFour();
        System.out.println(obj.isPowerOfFour(16));
        System.out.println(obj.isPowerOfFour(5));
    }
}
