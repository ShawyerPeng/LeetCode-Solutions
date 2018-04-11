package binary_search;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int n = mid ^ 1;
            if (nums[mid] == nums[n])
                left = mid;
            else
                right = mid;
        }
        if (nums[left] == nums[left ^ 1]) return nums[left];
        return nums[right];
    }

    public int singleNonDuplicate2(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //int n = mid % 2 == 0 ? mid + 1 : mid - 1;
            int n = mid ^ 1;
            if (nums[mid] == nums[n])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }

    public int singleNonDuplicate3(int[] nums) {
        // binary search
        int left = 0, right = nums.length / 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[2 * mid] != nums[2 * mid + 1]) right = mid;
            else left = mid + 1;
        }
        return nums[2 * left];
    }

    public static void main(String[] args) {
        SingleElementInASortedArray obj = new SingleElementInASortedArray();
        System.out.println(obj.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(obj.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));
        System.out.println(3^1);
    }
}