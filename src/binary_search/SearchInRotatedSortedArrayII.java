package binary_search;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii
 * 问题：
 * 思路：
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] < nums[mid]) {
                // 移动右指针
                if (nums[left] <= target && nums[mid] >= target) right = mid;
                else left = mid;
            } else if (nums[mid] < nums[left]) {
                // 移动左指针
                if (nums[right] >= target && nums[mid] <= target) left = mid;
                else right = mid;
            } else {
                left++;
            }
        }

        if (nums[left] == target || nums[right] == target) return true;
        return false;
    }

    public boolean search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            // 疑问：为什么写成 if (nums[mid] > nums[right]) 不行？
            if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid;
                else
                    left = mid;
            } else if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right])
                    left = mid;
                else
                    right = mid;
            } else {
                // 和前一题是一样的，只是添加了中间和边缘相等时，边缘移动一步
                left++;
            }
        }
        if (nums[left] == target || nums[right] == target) return true;
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII obj = new SearchInRotatedSortedArrayII();
        System.out.println(obj.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(obj.search(new int[]{5, 1, 3}, 0));
        System.out.println(obj.search(new int[]{1, 1, 1, 1, 0, 1, 1}, 1));
        System.out.println(obj.search(new int[]{3, 1, 1}, 3));
    }
}
