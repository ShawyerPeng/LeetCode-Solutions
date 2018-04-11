package bit_manipulation;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/counting-bits
 */
public class CountingBits {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // 找规律发现
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        CountingBits obj = new CountingBits();
        System.out.println(Arrays.toString(obj.countBits(5)));
    }
}
