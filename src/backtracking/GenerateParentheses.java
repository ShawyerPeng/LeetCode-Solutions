package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses
 * 问题：给n对"()"，求出所有字符串组合情况
 * 思路：当左括号数小于 n 时，可以增加左括号；
 * 当右括号数小于左括号数时，可以增加右括号。
 * 当左右括号数都等于 n 时 (base case)，把此 string 加入到最终结果中，并且返回上一级。
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        if (n == 0) return results;

        dfs(0, 0, n, new StringBuilder(), results);

        return results;
    }

    private void dfs(int left, int right, int n, StringBuilder path, List<String> results) {
        if (left < 0 || right < 0) return;
        if (left == n && right == n) {
            results.add(path.toString());
            return;
        }
        if (left < n) {
            path.append("(");
            // 注意这里不能写成++left，因为要回溯，不能改变left的值，下面的right同理
            dfs(left + 1, right, n, path, results);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(")");
            dfs(left, right + 1, n, path, results);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        System.out.println(obj.generateParenthesis(3));
    }
}
// http://www.cnblogs.com/grandyang/p/4444160.html
// https://simpleandstupid.com/2014/10/16/generate-parentheses-leetcode-%E8%A7%A3%E9%A2%98%E7%AC%94%E8%AE%B0/