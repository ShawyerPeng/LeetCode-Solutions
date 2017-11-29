package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning
 * 问题：分割字符串s，使所有子串都是回文字符串
 * 思路：
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) return results;

        dfs(0, new ArrayList<>(), s, results);

        return results;
    }

    private void dfs(int start, List<String> path, String s, List<List<String>> results) {
        // 当处理到传入的字符串长度等于 0, 则这个集合 list 满足条件，加入到结果集中
        if (start == s.length()) {
            results.add(new ArrayList<>(path));
            return;
        }

        // 字符串由前往后，先判断 s.substring(0, i) 是否是回文字符串
        // 如果是的话，继续调用函数 calResult，把 s.substring(i) 字符串传入做处理
        for (int i = start; i < s.length(); i++) {
            String subString = s.substring(start, i + 1);
            if (isPalindrome(subString)) {
                path.add(subString);
                dfs(i + 1, path, s, results);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * 判断一个字符串是否是回文字符串
     */
    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        System.out.println(obj.partition("aab"));
    }
}
// http://fisherlei.blogspot.com/2013/03/leetcode-palindrome-partitioning.html
// http://blog.luoyuanhang.com/2017/03/24/leetcode-131/
// http://shmilyaw-hotmail-com.iteye.com/blog/2153663