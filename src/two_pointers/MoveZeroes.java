package two_pointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes
 * 问题：給一個陣列，把裡面出現的 0 搬到陣列最後面，剩下的元素保持原本的排序。
 * 思路：使用另外一個變數 index 來記錄碰到的非 0 數字，遇到非 0 整數，將整數塞到 index 的位子，最後陣列長度扣除 index 就是 0 的數目，將陣列 index 之後的數字改為 0 就完成搬移的動作。
 */
public class MoveZeroes {
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
        int[] nums = new int[]{0, 1, 0, 3, 12};
        MoveZeroes obj = new MoveZeroes();
        obj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
// https://skyyen999.gitbooks.io/-leetcode-with-javascript/content/questions/283md.html
// https://segmentfault.com/a/1190000003768716