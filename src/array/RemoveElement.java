package array;

/**
 * https://leetcode.com/problems/remove-element
 * 问题：
 * 思路：
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            // 只有和val值不等，才有res++
            if (nums[i] != val) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();
        System.out.println(obj.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
