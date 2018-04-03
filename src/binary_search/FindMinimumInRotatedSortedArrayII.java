package binary_search;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right])
                right = mid;
            else if (nums[mid] > nums[right])
                left = mid;
            else
                // nums[mid]=nums[right] no idea, but we can eliminate nums[right];
                right--;
        }
        if (nums[left] < nums[right]) return nums[left];
        return nums[right];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII obj = new FindMinimumInRotatedSortedArrayII();
        System.out.println(obj.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }
}
