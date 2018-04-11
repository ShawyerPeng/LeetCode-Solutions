package two_pointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        // 字母的ASCII值在128以内
        boolean[] used = new boolean[128];
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            // j指定的字符没有出现过
            if (!used[s.charAt(j)]) {
                used[s.charAt(j)] = true;
                j++;
            } else {
                max = Math.max(max, j - i);
                // 如果j和i指向的不是同一个字符，就移动i，直到两元素相同
                while (i < j && s.charAt(j) != s.charAt(i)) {
                    used[s.charAt(i)] = false;
                    i++;
                }
                i++;
                j++;
            }
        }
        max = Math.max(max, j - i);
        return max;
    }

    /**
     * HashMap
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        // 存储字符和所在索引的映射
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 如果字符已经在HashMap中，移动左指针j到上次发现该字符的位置+1
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            // 移动右指针i扫描字符串，同时更新HashMap
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    /**
     * HashSet 抽象成滑动窗口
     * j是起点，[j, i)的长度就是所求
     */
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
                j++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        // right不断往右扩展，遍历整个母串s
        while (right < s.length()) {
            // 如果c和前面的字符串重复
            char rightChar = s.charAt(right);
            if (!set.contains(rightChar)) {
                // j指针对应字符没有出现在Set中，就把它添加进来，然后往后移动j，并更新max
                // 相当于[i, j)右边界向右滑动1个单位
                set.add(s.charAt(right++));
                max = Math.max(max, set.size());
            } else {
                // 如果出现重复了，就用i指针从头删除，直到能把j指针对应字符添加到HashSet中
                // 相当于区间[i, j)左边界向右滑动1个单位
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring5(String s) {
        int max = 0;
        if (s == null || s.length() == 0) return max;
        // 用来存放 s 字符串中的字符
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        // right不断往右扩展，遍历整个母串s
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (set.contains(rightChar)) {
                // 如果现在的不重复子串长度已大于原来的longestLength，则更新
                if (right - left > max) {
                    max = right - left;
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
                set.add(rightChar);
                // 注意边界条件，如果一个字符串完全没有重复，则不会进入到上面重复的情况，所以在这里要更新longestLength的值
                max = Math.max(max, set.size());
            }
            right++;
        }
        return max;
    }



    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
}