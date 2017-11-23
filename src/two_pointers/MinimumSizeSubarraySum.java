package two_pointers;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum
 * 时间复杂度：O(n)，空间复杂度: O(1)
 */
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        // 数组为空
        if (nums == null || nums.length == 0) return 0;

        // 滑动窗口首部的位置
        int head = 0;
        // 滑动窗口尾部的位置
        int tail = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // 这个条件能自动过滤 nums 为空的情况
        while (head < nums.length) {
            // 当有 [] 操作一定要预防数组越界
            if (tail > nums.length)
                break;

            // 满足sum >= s
            if (sum >= s) {
                // 如果新的长度比原来的最小长度小，那么更新这个最短子数组的长度
                if (minLength > tail - head)
                    minLength = tail - head;
                // remove head element
                sum -= nums[head];
                // head后移（即移除窗口中第一个元素）
                head++;
            }
            else {
                if (tail == nums.length)
                    break;
                else
                    // 若元素之和 < s，窗口右边沿向右延伸添加元素，直到元素之和 ≥s 为止
                    sum += nums[tail++];
            }
        }
        // 如果没有这样一个值，则返回0
        if (minLength == Integer.MAX_VALUE)
            return 0;
        else
            return minLength;
    }

    public static int minSubArrayLenBinarySearch(int s, int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int min = nums.length + 1;
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            if (sum[i + 1] >= s) {
                int left = binarySearch(sum, sum[i + 1] - s, 0, i + 1);
                min = Math.min(min, i + 1 - left);
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
    private static int binarySearch(int[] nums, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] <= target) {
            return end;
        } else {
            return start;
        }
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(s, nums));
        System.out.println(minSubArrayLenBinarySearch(s, nums));
    }
}
// http://www.jianshu.com/p/fb426ca8a679
// http://blog.csdn.net/wys2011101169/article/details/71108385
// http://www.jyuan92.com/blog/leetcode-minimum-size-subarray-sum/