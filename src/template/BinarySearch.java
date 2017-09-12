package template;

public class BinarySearch {
    // First Index
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0)  return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                end = mid;
            else if (nums[mid] < target)
                start = mid;
            else if (nums[mid] > target)
                end = mid;
        }

        if (nums[start] == target)
            return start;
        if (nums[end] == target)
            return end;

        return -1;
    }

    // Last Index
    public static int binarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0)  return -1;

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                start = mid;
            else if (nums[mid] < target)
                start = mid;
            else if (nums[mid] > target)
                end = mid;
        }

        if (nums[end] == target)
            return end;
        if (nums[start] == target)
            return start;

        return -1;
    }

    public static void main(String[] args) {

    }
}
