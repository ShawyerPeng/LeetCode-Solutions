package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * 问题：枚举所有可能的IP地址
 * 思路：记住for循环的是4个段，而不是组成每一段的长度
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return results;
        dfs(1, 0, "", s, results);
        return results;
    }

    /**
     * @param n       IP地址的第几个段
     * @param start   遍历到String哪个的位置
     * @param path    暂存的字符串
     * @param s       目标字符串
     * @param results 结果
     */
    private void dfs(int n, int start, String path, String s, List<String> results) {
        if (start >= s.length()) return;
        if (n == 4) {
            String str = s.substring(start);
            if (isValid(str)) {
                results.add(path + "." + str);
            }
            return;
        }

        // 枚举当前段的长度，每一层从 1 个字符开始取一直到 3 个字符
        for (int i = 1; i <= 3 && (i + start <= s.length()); i++) {
            String subString = s.substring(start, start + i);
            // 再加一个 isValid 的函数来验证取的字符是否是合法数字，如果是合法的数字，我们再进行下一层递归，否则跳过
            if (isValid(subString)) {
                if (n == 1)
                    dfs(n + 1, start + i, subString, s, results);
                else
                    dfs(n + 1, start + i, path + "." + subString, s, results);
            }
        }
    }

    /**
     * 判断该段IP地址是否有效
     */
    private boolean isValid(String str) {
        if (str == null || str.length() > 3) return false;
        int num = Integer.parseInt(str);
        // 不能有前导0
        if (str.charAt(0) == '0' && str.length() > 1) return false;
        // 三位数不能超过255
        if (num >= 0 && num <= 255) return true;
        return false;
    }

    public static void main(String[] args) {
        RestoreIPAddresses obj = new RestoreIPAddresses();
        System.out.println(obj.restoreIpAddresses("25525511135"));
    }
}
// http://blog.csdn.net/linhuanmars/article/details/24683699
// http://www.cnblogs.com/grandyang/p/4305572.html
// http://bangbingsyb.blogspot.com/2014/11/leetcode-restore-ip-addresses.html
// https://www.youtube.com/watch?v=nxBMEvLqDzY