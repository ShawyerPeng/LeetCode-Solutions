package newcoder.meituan;

/**
 * https://www.nowcoder.com/test/question/d66442d58616473dafb91b168d8ebd4d?pid=5583018&tid=12631084
 * 问题：大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为 1 时可以走一步，点数为 2 时可以走两步，点数为 n 时可以走 n 步。
 * 求玩家走到第 n 步（n<= 骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 * 思路：动态规划
 */
/*
f(n)=f(n-1)+f(n-2)+...+1;
在玩家走到第n步的情况，
可能是先走了n-1步，剩下1步到达；
也可能是先走n-2步，剩下再走2步到达；
...；
也可能是先走了1步，剩下再走n-1步。

即 f(n) 是f(n-1)...f(1)的情况相加，再加上最后一步。
*/
public class DaFuWeng {
    public int result(int n) {
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DaFuWeng obj = new DaFuWeng();
        System.out.println(obj.result(3));
    }
}
