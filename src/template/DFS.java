package template;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    private void dfs(List<List<Integer>> sub, List<Integer> list, int pos, int[] nums) {
        // 递归出口
        if (list.size() == 3) {
            sub.add(new ArrayList<Integer>(list));
        }

        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i - 1] == nums[i])
                continue;
            if (list.size() < 3) {
                list.add(nums[i]);
                dfs(sub, list, i + 1, nums);
                list.remove(list.size() - 1);
            } else
                break;
        }
    }

    public static void main(String[] args) {

    }
}
// http://www.jiuzhang.com/solution/dfs-template/
