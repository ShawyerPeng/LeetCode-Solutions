package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram
 * https://www.youtube.com/watch?v=3Vf3lUjf_xQ
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }

    /**
     * Counting Sort 计数排序
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        // 26个字母
        int[] count = new int[26];
        // 字母计数
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int num : count) {
            // 如果s和t同构异形，那么count每个位置都是0
            if (num != 0) return false;
        }
        return true;
    }

    public boolean isAnagram3(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : t.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            } else {
                if (map.get(ch) > 1) map.put(ch, map.get(ch) - 1);
                else if (map.get(ch) == 1) map.remove(ch);
            }
        }

        if (map.size() > 0) return false;

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        System.out.println(obj.isAnagram("anagram", "nagaram"));
        System.out.println(obj.isAnagram("rat", "car"));
    }
}
