package bit_manipulation;

/**
 * https://leetcode.com/problems/number-of-1-bits
 */
public class NumberOf1Bits {
    /**
     * 使用n&1的方法，每次右移1位判断该位是否为1
     */
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 每一次与1之后的结果给res
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    /**
     * 使用n&(n-1)的方法。n&(n-1)能将n的二进制表示中的最低位为1的改为0
     */
    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOf1Bits obj = new NumberOf1Bits();
        System.out.println(obj.hammingWeight(11));
    }
}