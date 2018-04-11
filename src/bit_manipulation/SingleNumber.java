package bit_manipulation;

/**
 * https://leetcode.com/problems/single-number
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        SingleNumber obj = new SingleNumber();
        System.out.println(obj.singleNumber(new int[]{1, 5, 2, 3, 5, 3, 1}));
        System.out.println(12 ^ 8 ^ 12);
    }
}
