package depth_first_search;

/**
 * https://leetcode.com/problems/target-sum
 * 问题：加或减n个数，使得它们的和为S
 * 思路：
 */
public class TargetSum {
    private int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return result;

        dfs(0, 0, S, nums);

        return result;
    }

    private void dfs(int index, int sum, final int S, final int[] nums) {
        // 当 index 为 nums 数组的大小的时候，判断 sum 与 S 是否相等，如果相等就 result++
        // sum 为当前 index 步数情况下的前面所有部分的总和
        if (index == nums.length) {
            if (sum == S) ++result;
            return;
        }

        // 尝试每次添加 + 或者 -。这里千万不要加 for 循环，因为我们只是从 index0 开始
        dfs(index + 1, sum + nums[index], S, nums);
        dfs(index + 1, sum - nums[index], S, nums);
    }

    public static void main(String[] args) {
        TargetSum obj = new TargetSum();
        System.out.println(obj.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
// http://rainykat.blogspot.com/2017/01/leetcodegf-494-target-sum-dfs.html
// http://www.cnblogs.com/grandyang/p/6395843.html