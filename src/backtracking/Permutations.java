package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        helper(nums, new ArrayList<>(), results);
        return results;
    }

    private void helper(int[] nums, ArrayList<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // nums[i]已经加入到list中了，再枚举到它的时候，就不应该再加入了
            if (path.contains(nums[i])) continue;
            // 删除了最后一个元素之后，i往下循环到下一个，该句负责加入枚举到的新元素
            path.add(nums[i]);
            helper(nums, path, res);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        helper2(nums, 0, results);
        return results;
    }

    private void helper2(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            List<Integer> path = new ArrayList<>();
            for (int num : nums) path.add(num);
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            helper2(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        Permutations prob = new Permutations();
        System.out.println(prob.permute2(new int[]{1, 2, 3}));
    }
}
