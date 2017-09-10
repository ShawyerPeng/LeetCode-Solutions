package dynamic_programming;

/**
 * （1）00：res[i]=0（无法解析，没有可行解析方式）；
 * （2）10, 20：res[i]=res[i-2]（只有第二种情况成立）；
 * （3）11-19, 21-26：res[i]=res[i-1]+res[i-2]（两种情况都可行）；
 * （4）01-09, 27-99：res[i]=res[i-1]（只有第一种情况可行）；
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        int n = s.length();
        if (s == null || n == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];

        // 初始条件：若第一个字符为'0'，则无法解码
        dp[0] = 1;
        char[] str = s.toCharArray();
        if (str[0] == '0')
            dp[1] = 0;
        else
            dp[1] = 1;

        for (int i = 1; i < n; i++) {
            if (str[i] == '0') {
                if (str[i - 1] == '1' || str[i - 1] == '2')
                    dp[i + 1] = dp[i - 1];
                else
                    dp[i + 1] = 0;
            } else {
                if (str[i - 1] == '0' || str[i - 1] >= '3') // 上一个字符为 0 或 3
                    dp[i + 1] = dp[i];
                else if (str[i - 1] == '2' && str[i] >= '7' && str[i] <= '9')
                    dp[i + 1] = dp[i];
                else {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "12";
        System.out.println(numDecodings(s));
    }
}
// 参考：http://blog.csdn.net/ifollowrivers/article/details/77374164
// http://blog.csdn.net/linhuanmars/article/details/24570759