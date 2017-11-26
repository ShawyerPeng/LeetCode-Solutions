package template;

import java.util.*;

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

    /**
     * DFS的非递归方法
     */
    public boolean dfsStack(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode p = stack.pop();
            if (p == null) {
                continue;
            }
            stack.push(p.left);
            stack.push(p.right);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
// http://www.jiuzhang.com/solution/dfs-template/
