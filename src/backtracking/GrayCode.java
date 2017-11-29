package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code
 * 问题：求格雷码的序列
 * 思路：可以发现，n 的格雷码，就是 n-1 的格雷码，再加上它们的逆序前面多一个 1。
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> results = new ArrayList<>();
        // 加入初始值0
        results.add(0);
        if (n == 0) return results;

        results = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        int originalsize = results.size();
        for (int i = originalsize - 1; i >= 0; i--) {
            results.add(addNumber + results.get(i));
        }
        return results;

        //for (int i = 0; i < n; i++) {
        //    results.add(grayCode(n - 1).get(i) + 10 ^ n);
        //}
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> results = new ArrayList<>();
        dfs(n, results);
        return results;
    }

    private void dfs(int n, List<Integer> results) {
        if (n == 0) {
            results.add(0);
            // 递归需要有结束条件再return
            return;
        }

        // 放在 for 循环之前
        dfs(n - 1, results);

        int numToAdd = 1 << (n - 1);
        for (int i = results.size() - 1; i >= 0; i--) {
            results.add(numToAdd + results.get(i));
        }
    }

    public static void main(String[] args) {
        GrayCode obj = new GrayCode();
        System.out.println(obj.grayCode(2));
        System.out.println(obj.grayCode(3));
        System.out.println(obj.grayCode2(2));
        System.out.println(obj.grayCode2(3));
    }

}
// https://segmentfault.com/a/1190000003741403
// https://www.jiuzhang.com/qa/2554/
// http://blog.csdn.net/jmspan/article/details/51473522