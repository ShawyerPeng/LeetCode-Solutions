package binary_search;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right])
                right = mid;
            else
                left = mid;
        }
        if (nums[left] < nums[right]) return nums[left];
        return nums[right];
    }

    public static int findMin2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int target = nums[nums.length - 1];

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target)
                left = mid;
            else
                right = mid;
        }

        if (nums[left] <= target) {
            return nums[left];
        } else {
            return nums[right];
        }
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(obj.findMin(nums));
    }
}
