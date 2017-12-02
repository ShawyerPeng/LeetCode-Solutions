package binary_search_tree;

/**
 * https://leetcode.com/problems/count-of-range-sum
 * 问题：
 * 思路：
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int ans = 0;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
        ans = sort(sum, 0, nums.length + 1, lower, upper);
        return ans;
    }

    public int sort(long[] sum, int l, int r, int lower, int upper) {
        if (r - l <= 1) return 0;
        int ret = 0;
        int mid = (l + r) >> 1;
        long[] temp = new long[r - l];
        ret += sort(sum, l, mid, lower, upper) + sort(sum, mid, r, lower, upper);
        int rl = mid, rr = mid, j = mid;
        for (int i = l, k = 0; i < mid; ++i) {
            if (rl < r && sum[rl] - sum[i] <= upper) {
                while (rl < r && sum[rl] - sum[i] < lower) rl++;
                while (rr < r && sum[rr] - sum[i] <= upper) rr++;
                ret += rr - rl;
            }
            while (j < r && sum[j] < sum[i]) temp[k++] = sum[j++];
            temp[k++] = sum[i];
        }
        System.arraycopy(temp, 0, sum, l, j - l);
        return ret;
    }

    public static void main(String[] args) {
        CountOfRangeSum obj = new CountOfRangeSum();
        System.out.println(obj.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
// http://qsxuan.com/articles/930.html
// http://www.cnblogs.com/zichi/p/leetcode-327-count-of-range-sum.html
// http://blog.csdn.net/qq508618087/article/details/51435944