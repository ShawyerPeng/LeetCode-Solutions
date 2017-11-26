package hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
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

    public static boolean isAnagram2(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (Character ch : t.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        Iterator it = map1.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!map2.containsKey(entry.getKey())) {
                return false;
            }
            if (map2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
// https://www.programcreek.com/2014/05/leetcode-valid-anagram-java/