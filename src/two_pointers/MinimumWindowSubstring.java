package two_pointers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring
 * 问题：给定字符串 S 和字符串 T，找到 S 中的最小窗口，其中将包含 T 中的所有字符。
 * 如果 S 中没有覆盖 T 中所有字符的窗口，则返回空字符串。如果有多个这样的窗口，可以确保在 S 中始终只有一个唯一的最小窗口。
 * 思路：双指针，动态维护一个区间。
 * 尾指针不断往后扫，当扫到有一个窗口包含了所有 T 的字符后，然后再收缩头指针，直到不能再收缩为止。
 * 最后记录所有可能的情况中窗口最小的。
 * 因为可以跳过没在字典里面的字符，所以遇到没在字典里面的字符可以继续移动窗口右端
 * 移动窗口左端的条件是当找到满足条件的串之后，一直移动窗口左端直到有字典里的字符不再在窗口里
 * 算法的时间复杂度是 O(n), 其中 n 是字符串的长度，因为每个字符再维护窗口的过程中不会被访问多于两次。
 * 空间复杂度则是 O(字典的大小)，也就是代码中 T 的长度。
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String result = "";
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return result;

        // 用来存放 t 字符串中的字符及出现的次数
        Map<Character, Integer> map = new HashMap<>();
        // 标记变量，当等于 t.size() 的时候，该窗口就是一个完全包含字符串 t 的子串
        int count = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;

        // 将 t 放入 map 中，就是为了加速
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                // key 包含字典中所有字符，value 就是该字符的数量
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            } else {
                map.put(t.charAt(i), 1);
            }
        }

        // right不断往右扩展，遍历整个母串s
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果这个字符在map中
            if (map.containsKey(c)) {
                // 遇到字典中字符时就将对应字符的数量减一
                // 扩展窗口，窗口中包含一个 T 中子元素，map中存储的对应count–-
                map.put(c, map.get(c) - 1);
                // 如果还有某个字符的次数有剩余，则count++
                if (map.get(c) >= 0) {
                    count++;
                }

                // 表示该窗口中已经全部包含 t 了
                // 当 count 达到子串长度，说明之前遍历的这些有符合条件的串，用一个 left 指针帮忙找
                // left 指针帮忙找第一个在 HashMap 中存过的，并且找到后给计数加 1 后的总计数是大于 0 的
                // 判断是否为全局最小长度，如果是，更新返回字符串 result，更新最小长度，如果不是，继续找。
                while (t.length() == count) {
                    // 如果新的窗口更小，则更新
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        result = s.substring(left, left + minLen);
                        //result = s.substring(left, right + 1);
                    }
                    // 窗口大小超过了 k，则需要删除 nums[left]，并且 left++，窗口需要缩减了
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    // 缩减窗口
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(minWindow(S, T));
    }
}
// http://blog.csdn.net/yy254117440/article/details/53025142
// http://blog.csdn.net/linhuanmars/article/details/20343903
// https://gist.github.com/cangoal/93192f40e71b2447a9e4
// http://blog.csdn.net/lu597203933/article/details/46389491