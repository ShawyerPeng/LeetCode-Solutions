package binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/is-subsequence
 * 问题：Given a string s and a string t, check if s is subsequence of t.
 * 思路：
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        } else if (t.length() < s.length()) {
            return false;
        } else if (s.length() == 0) {
            return true;
        }

        List<Integer>[] idx = new List[256];
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (idx[curr] == null) {
                idx[curr] = new ArrayList<Integer>();
            }
            idx[curr].add(i);
        }

        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (idx[curr] == null) {
                return false;
            }
            List<Integer> list = idx[curr];
            int index = Collections.binarySearch(list, pre);
            if (index < 0) {
                index = -index - 1;
            }
            if (index >= list.size()) {
                return false;
            }
            pre = list.get(index) + 1;
        }
        return true;
    }

    /**
     * 两个指针就可以，无论如何指向 T 的每轮都要前进，而 S 的那个只有当当前指针下 S 和 T 一致的情况下才前进
     */
    public boolean isSubsequenceTwoPointers(String s, String t) {
        int i = 0, j = 0;
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        while (i < ss.length && j < tt.length) {
            if (ss[i] == tt[j]) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence obj = new IsSubsequence();
        System.out.println(obj.isSubsequence("abc", "ahbgdc"));
        System.out.println(obj.isSubsequence("axc", "ahbgdc"));
        System.out.println(obj.isSubsequenceTwoPointers("abc", "ahbgdc"));
        System.out.println(obj.isSubsequenceTwoPointers("axc", "ahbgdc"));
    }
}
// http://www.jianshu.com/p/bb4cb2684dea
// http://www.cnblogs.com/EdwardLiu/p/6116896.html