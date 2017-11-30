package greedy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies
 * 问题：有若干个熊孩子和若干个大小不一的饼干，每个熊孩子都有一个贪心指数，如果拿不到那么大的饼干就伐开心。要求满足足够多的熊孩子。
 * 思路：通过贪心算法，优先满足比较容易满足的熊孩子，并且尽可能地派出饼干。
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // 将两个数组都按降序排列
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int gPos = 0, sPos = 0, glen = g.length, slen = s.length;
        while (gPos < glen && sPos < slen) {
            if (s[sPos] < g[gPos]) gPos++;
            else {
                ans++;
                sPos++;
                gPos++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AssignCookies obj = new AssignCookies();
        System.out.println(obj.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(obj.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}