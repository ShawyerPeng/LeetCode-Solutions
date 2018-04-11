package bit_manipulation;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range
 */
public class BitwiseANDOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            // m右移1位，相当于删除
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m << offset;
    }

    public static void main(String[] args) {
        BitwiseANDOfNumbersRange obj = new BitwiseANDOfNumbersRange();
        System.out.println(obj.rangeBitwiseAnd(5, 7));
    }
}
