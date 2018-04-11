package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void helper(int[] nums, int pos, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = pos; i < nums.length; i++) {
            // 解决重复问题：若要尝试的要放到集合里面的数i不等于pos（上一个取的数加1）
            if (i != pos && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            helper(nums, i + 1, path, res);
            // 相当于出栈
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII prob = new SubsetsII();
        System.out.println(prob.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
