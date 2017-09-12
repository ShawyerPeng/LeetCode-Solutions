package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) return res;
        if (nums.length == 0) {
            res.add(new ArrayList<>());
            return res;
        }

        Arrays.sort(nums);

        int[] visited = new int[nums.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }

        subsetsHelper(new ArrayList<>(), nums, visited, res);

        return res;
    }

    private void subsetsHelper(ArrayList<Integer> path,
                               int[] nums,
                               int[] visited,
                               List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 为了去除重复元素影响
            if (visited[i] == 1 ||
                    (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0)) {
                continue;
            }
            /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二个2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
            */
            visited[i] = 1;
            path.add(nums[i]);
            subsetsHelper(path, nums, visited, res);
            path.remove(path.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        PermutationsII prob = new PermutationsII();
        System.out.println(prob.permuteUnique(new int[]{1, 1, 2}));
    }
}
