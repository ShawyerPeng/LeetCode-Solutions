package binary_search;

import java.util.Arrays;

/**
 *
 */
public class SearchForARange {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start, end, mid;
        int[] bound = new int[2];

        // search for left bound
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            bound[0] = start;
        } else if (nums[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        // search for right bound
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            bound[1] = end;
        } else if (nums[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        return bound;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;

        int startIndex = -1, endIndex = -1;

        // 找起点startIndex
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid;
            else
                right = mid;
        }
        // 优先判断nums[left]
        if (nums[left] == target) startIndex = left;
        else if (nums[right] == target) startIndex = right;
        if (startIndex == -1) return res;

        // 找终点endIndex
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target)
                right = mid;
            else
                left = mid;
        }
        // 优先判断nums[right]
        if (nums[right] == target) endIndex = right;
        else if (nums[left] == target) endIndex = left;
        res[0] = startIndex;
        res[1] = endIndex;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        searchRange(nums, target);

        SearchForARange obj = new SearchForARange();
        System.out.println(Arrays.toString(obj.searchRange2(nums, target)));
    }
}
