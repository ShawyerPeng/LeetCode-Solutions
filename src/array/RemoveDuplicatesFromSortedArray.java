package array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 第一个数肯定保留
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            // 后面一个数和前一个数相比较
            if (nums[i - 1] != nums[i]) {
                nums[res++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        System.out.println(obj.removeDuplicates(new int[]{1, 1, 2}));
    }
}
