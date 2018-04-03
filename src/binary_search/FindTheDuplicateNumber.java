package binary_search;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 问题：
 * 思路：
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 找到中间那个数
            int mid = left + (right - left) / 2;
            int count = 0;
            // 由于数组非有序，要用for循环遍历整个数组，计算总数组中有多少个数小于等于中间数
            for (int i = 0; i < nums.length; i++) {
                // 比较的是mid而不是nums[mid]
                if (nums[i] <= mid) count++;
            }
            // 如果小于等于中间数的数的个数大于中间数mid，说明前半部分必有重复
            if (count > mid)
                right = mid - 1;
            // 否则后半部分必有重复
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber obj = new FindTheDuplicateNumber();
        System.out.println(obj.findDuplicate(new int[]{1, 2, 3, 4, 2}));
    }
}
