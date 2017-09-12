package binary_search;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[end]) {
                // if mid equals to end, that means it's fine to remove end
                // the smallest element won't be removed
                end--;
            } else if (nums[mid] < nums[end]) {
                end = mid;
                // of course you can merge == & <
            } else {
                start = mid;
                // or start = mid + 1
            }
        }

        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }

    public static void main(String[] args) {

    }
}
// 参考：http://www.jiuzhang.com/solution/find-minimum-in-rotated-sorted-array-ii/