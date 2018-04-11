package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        // 存放每一个左括号的位置
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // 当前括号组合的最左侧边界
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 当前括号组合为空
                if (stack.empty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.empty()) {
                        res = Math.max(res, i - start);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();
        System.out.println(obj.longestValidParentheses(")()())"));
    }
}