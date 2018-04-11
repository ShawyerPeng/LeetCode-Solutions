package binary_search;

public class SearchInsertPosition {
    // （找到最后一个小于target的）+1，或找到第一个大于等于target的
    // (find last postion < target) + 1
    // find first position >= target

    // find the first position >= target
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] >= target) {
            return start;
        } else if (nums[end] >= target) {
            return end;
        } else {
            return end + 1;
        }
    }

    // find the last position < target, return +1，要特判一下target小于所有数组里面的元素
    public static int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        int start = 0, end = nums.length - 1;
        int mid;

        if (target < nums[0]) {
            return 0;
        }
        // find the last number less than target
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[end] == target) {
            return end;
        }
        if (nums[end] < target) {
            return end + 1;
        }
        if (nums[start] == target) {
            return start;
        }
        return start + 1;
    }

    public int searchInsert3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else
                return mid;
        }
        return left;
    }

    public int searchInsert4(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
            else
                return mid;
        }
        return left;
    }

    public int searchInsert5(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid;
            else if (nums[mid] > target)
                right = mid;
            else
                return mid;
        }
        if (nums[left] >= target) return left;
        else if (nums[right] >= target) return right;
        else return right + 1;// 找不到要找的数字的情况，此时应返回数组长度
    }

    public static void main(String[] args) {
        SearchInsertPosition obj = new SearchInsertPosition();
        System.out.println(obj.searchInsert5(new int[]{1, 3, 5, 6}, 5));
    }
}
