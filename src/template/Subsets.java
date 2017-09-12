package template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /**
     * Recursion
     */
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

    // 递归三要素
    // 1. 递归的定义：在 nums 中找到所有以 subset 开头的的集合，并放到 res
    private void subsetsHelper(ArrayList<Integer> path,
                               int[] nums,
                               int pos,
                               List<List<Integer>> res) {
        // 2. 递归的拆解
        res.add(new ArrayList<>(path));

        for (int i = pos; i < nums.length; i++) {
            // [1] -> [1,2]
            path.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 res
            subsetsHelper(path, nums, i + 1, res);
            // [1,2] -> [1]  回溯，无后向性
            path.remove(path.size() - 1);
        }

        // 3. 递归的出口
        // return;
    }

    /**
     * Non Recursion
     */
    public List<List<Integer>> subsetsNonRec(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);

        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ...
        // 7 -> 111 -> [1,2,3]
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // check whether the jth digit in i's binary representation is 1
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{1, 2, 3}));
    }
}
