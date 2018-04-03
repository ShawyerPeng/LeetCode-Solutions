package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        Arrays.sort(nums);

        subsetsHelper(new ArrayList<>(), nums, 0, res);

        return res;
    }

    private void subsetsHelper(ArrayList<Integer> path, int[] nums, int pos, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = pos; i < nums.length; i++) {
            // [1] -> [1,2]
            path.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 res
            subsetsHelper(path, nums, i + 1, res);
            // [1,2] -> [1]  回溯，无后向性
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }
}
