package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch
 * 问题：给定一个二进制的表，其中用 1，2，4，8 表示小时，1，2，4，8，16，32 表示分钟。求在 n 盏灯亮的情况下，可以表示的所有时间。
 * 思路：可以直接 DFS，注意小时 < 12, 分钟 < 60。感觉可以位运算。
 */
public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> results = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};

        // 最外循环，为每一个时针和分针的灯的情况组合一次
        for (int i = 0; i <= num; i++) {
            // 得到时针在有 i 个灯亮时可能的组合数
            List<Integer> list1 = new ArrayList<>();
            dfs(i, 0, 0, nums1, list1);
            // 得到分针在有 num-i 个灯亮时可能的组合数
            List<Integer> list2 = new ArrayList<>();
            dfs(num - i, 0, 0, nums2, list2);
            // 外循环，遍历时针来组合
            for (int num1 : list1) {
                if (num1 >= 12) continue;
                // 内循环，组合时针下相应的分针
                for (int num2 : list2) {
                    if (num2 >= 60) continue;
                    // 用一个三元运算符就解决格式问题
                    results.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                    // 等价于: res.add(String.format("%d:%02d", num1,num2)); 通过 %02d 来调整格式
                }
            }
        }
        return results;
    }

    /**
     * 用递归来实现回溯
     */
    private void dfs(int count, int pos, int sum, int[] nums, List<Integer> results) {
        // 递归出口
        if (count == 0) {
            results.add(sum);
            return;
        }

        // 这其实就是在进行 DFS 遍历，先走完 i，再走 i+1,i+2...
        for (int i = pos; i < nums.length; i++) {
            dfs(count - 1, i + 1, sum + nums[i], nums, results);
        }
    }

    public static void main(String[] args) {
        BinaryWatch obj = new BinaryWatch();
        System.out.println(obj.readBinaryWatch(1));
    }
}
// http://blog.csdn.net/carmelo_z/article/details/75285681
// http://www.jianshu.com/p/e80dbd96c0f8
// http://blog.csdn.net/noadu/article/details/73867351