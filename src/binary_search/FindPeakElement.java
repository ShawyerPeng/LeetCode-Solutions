package binary_search;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        // 1.答案在之间，2.不会出界
        // Lintcode：有假设A[0] < A[1] && A[A.length - 2] > A[A.length - 1]
//        int start = 1;
//        int end = nums.length - 2;

        // Leetcode：没有该假设，所以第一个元素或最后一个元素可以是peak element
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;

            // 峰值P满足：A[P] > A[P-1]且A[P] > A[P+1]
            // nums[mid]不是最大值（比左边相邻的元素小），那么Peak一定在mid的左边
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
                // start = mid;  不影响结果
            }
        }

        // 判断取得的是第一个还是第二个
        if (nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }
    }

    public int findPeakElement2(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int left = 0;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // 如果一个数nums[mid]比前面一个和后面一个数都要大，那么就是我们要找的数(peak element)
            if ((mid == 0 || nums[mid] > nums[mid - 1]) &&
                    (mid == nums.length - 1 || nums[mid] > nums[mid + 1]))
                return mid;
            else if (mid > 0 && nums[mid] < nums[mid - 1])
                right = mid;
            else
                left = mid;
        }
        if (nums[left] > nums[right]) return left;
        return right;
    }

    public static void main(String[] args) {
        FindPeakElement obj = new FindPeakElement();
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(obj.findPeakElement2(nums));
    }
}
