package string;

/**
 * https://leetcode.com/problems/longest-palindromic-substring
 * https://www.youtube.com/watch?v=m2Mk9JN5T4A
 */
public class LongestPalindromicSubstring {
    /**
     * 动态规划
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        int n = s.length();
        // 记录当前SubString是否回文
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                // 判断i~j位置的字符串是否是回文串
                // dp[i][j]是回文串等价于：s[i]和s[j]字符相等，且中间部分的字符串（i+1~j-1位置）是回文串
                // j-i<=2 一定要写在前面，因为极限情况（比如i=3,j=2，i已经大于j了，这是不行的）
                dp[i][j] = (s.charAt(i) == s.charAt(j)) &&
                        ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 中心扩散法
     */
    private String res = "";

    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            // 分情况讨论，回文字符串中间可以是单个也可以是两个相同的
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 因为退出循环时已经不满足回文的情况了，因此left和right都要移动到最后一次回文的位置
        // 又由于subString只截取[left,right)的字符串，因此right不必往左移
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) res = cur;
    }

    private int longestLength = 0;
    private int longestStart = 0;

    public String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            checkOddPalindrome(s, i);
            checkEvenPalindrome(s, i);
        }
        return s.substring(longestStart, longestStart + longestLength);
    }

    private void checkOddPalindrome(String s, int index) {
        int start = index;
        int end = index;
        // 判断前一位和后一位是否相等
        while (start > 0 && end < s.length() - 1 && s.charAt(start - 1) == s.charAt(end + 1)) {
            start--;
            end++;
        }
        if (end - start + 1 > longestLength) {
            longestLength = end - start + 1;
            longestStart = start;
        }
    }

    private void checkEvenPalindrome(String s, int index) {
        int start = index;
        int end = Math.min(index + 1, s.length() - 1);
        // 判断前一位和后一位是否相等
        while (start > 0 && end < s.length() - 1 &&
                s.charAt(start - 1) == s.charAt(end + 1)
                && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (end - start + 1 > longestLength && s.charAt(start) == s.charAt(end)) {
            longestLength = end - start + 1;
            longestStart = start;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome("babad"));
        obj.longestStart = 0;
        obj.longestLength = 0;
        obj.res = "";
        System.out.println(obj.longestPalindrome("cbbd"));
    }
}
