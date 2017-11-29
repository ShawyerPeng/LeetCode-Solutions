package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        subsetsHelper(new ArrayList<>(), nums, res);

        return res;
    }

    private void subsetsHelper(ArrayList<Integer> path,
                               int[] nums,
                               List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // nums[i]已经加入到list中了，再枚举到它的时候，就不应该再加入了
            if (path.contains(nums[i])) {
                continue;
            }
            // 删除了最后一个元素之后，i 往下循环到下一个，该句负责加入枚举到的新元素
            path.add(nums[i]);
            subsetsHelper(path, nums, res);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations prob = new Permutations();
        System.out.println(prob.permute(new int[]{1, 2, 3}));
    }
}
