package template;

import java.util.ArrayList;
import java.util.List;

public class Permutation2 {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> rst = new ArrayList<>();
        if (nums == null) return rst;
        if (nums.length == 0) {
            rst.add(new ArrayList<>());
            return rst;
        }

        ArrayList<Integer> list = new ArrayList<>();
        helper(rst, list, nums);
        return rst;
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
        Permutation2 permutation = new Permutation2();
        System.out.println(permutation.permute(new int[]{0, 5, 4}));
    }
}
// 参考：https://www.jiuzhang.com/qa/5436/