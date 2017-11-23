package two_pointers;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 * 问题：Given a string, find the length of the longest substring without repeating characters.
 * 思路：
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        if (s == null || s.length() == 0) return longestLength;

        // 用来存放 s 字符串中的字符
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;

        // right不断往右扩展，遍历整个母串s
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 如果c和前面的字符串重复
            if (set.contains(c)) {
                // 如果现在的不重复子串长度已大于原来的longestLength，则更新
                if (right - left > longestLength) {
                    longestLength = right - left;
                }
                // 当前的重复状况是：在最右边新加入了一个字符，刚好和前面的某个字符重复了
                // 所以我们要找到是哪个字符和它重复了
                // 那就将left不断右移，直到找到left对应字符和right对应字符相等即重复，再将left对应字符remove，left++
                while (s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                // 如果c和前面的字符串不重复，则添加到set中
                set.add(c);
                // 注意边界条件，如果一个字符串完全没有重复，则不会进入到上面重复的情况，所以在这里要更新longestLength的值
                longestLength = Math.max(longestLength, set.size());
            }
        }

        return longestLength;
    }

    public int lengthOfLongestSubstringHashMap(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abcdefg"));
    }
}
