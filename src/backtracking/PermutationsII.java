package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        helper(nums, visited, new ArrayList<>(), results);
        return results;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 为了去除重复元素影响
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) continue;
            visited[i] = true;
            path.add(nums[i]);
            helper(nums, visited, path, res);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        PermutationsII prob = new PermutationsII();
        System.out.println(prob.permuteUnique(new int[]{1, 1, 2}));
    }
}
