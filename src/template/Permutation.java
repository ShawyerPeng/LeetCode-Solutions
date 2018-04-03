package template;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (nums == null) return results;
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        ArrayList<Integer> list = new ArrayList<>();
        helper(results, list, nums);
        return results;
    }

    private void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(rst, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(new int[]{0, 5, 4}));
    }
}
// 参考：https://www.jiuzhang.com/qa/5436/