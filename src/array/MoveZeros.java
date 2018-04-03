package array;

import java.util.Arrays;

/**
 * 问题：将一个给定数组中所有的0都移到后面，把非零数前移，要求不能改变非零数的相对应的位置关系，而且不能拷贝额外的数组
 * 思路：
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int index = 0;
        // 将非0数字都尽可能向前排
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        // 将剩余的都置0
        for (; index < nums.length; index++) {
            nums[index] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros obj = new MoveZeros();
        int[] nums = new int[]{4, 2, 0, 9, 0, 8, 0, 7};
        obj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
