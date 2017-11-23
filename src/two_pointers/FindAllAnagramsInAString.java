package two_pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 * 问题：在 s 中找字符串 p 的所有变位次的位置，所谓变位次就是字符种类个数均相同但是顺序可以不同的两个词
 * 思路：
 */
public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return res;
        if (s.length() < p.length()) return res;

        int[] pattern = new int[26];
        int[] window = new int[26];
        int pLen = p.length();

        for (int i = 0; i < pLen; i++) {
            int pIdx = p.charAt(i) - 'a';
            int sIdx = s.charAt(i) - 'a';
            pattern[pIdx]++;
            window[sIdx]++;
        }
        if (isAnagram(window, pattern)) res.add(0);
        for (int i = pLen; i < s.length(); i++) {
            int preIdx = i - pLen;
            window[s.charAt(preIdx) - 'a']--;
            window[s.charAt(i) - 'a']++;
            if (isAnagram(window, pattern)) res.add(i - pLen + 1);
        }
        return res;
    }

    private static boolean isAnagram(int[] window, int[] pattern) {
        for (int i = 0; i < pattern.length; i++) {
            if (window[i] != pattern[i]) return false;
        }
        return true;
    }

    public static List<Integer> findAnagrams2(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null) return result;
        // 初始化一个长度为 0 的窗口
        int left = 0, right = 0, count = p.length();

        // 构造一个 map，对于 p 中的每个字符 char，都有 map[char]++
        int[] map = new int[256];
        // 初始化map
        for (char c : p.toCharArray()) map[c]++;

        // 滑动窗口
        char[] sc = s.toCharArray();

        while (right < s.length()) {
            // 1：扩展窗口，right，窗口中包含一个T中子元素，count--
            if (map[sc[right++]]-- >= 1) count--;
            // 2：通过count或其他限定值，得到一个可能解。
            if (count == 0) result.add(left);
            // 3：只要窗口中有可能解，那么缩小窗口直到不包含可能解。
            if (right - left == p.length() && map[sc[left++]]++ >= 0) count++;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
// http://blog.csdn.net/cloudox_/article/details/53080159
// https://dyang2016.wordpress.com/2016/10/26/438-find-all-anagrams-in-a-string/