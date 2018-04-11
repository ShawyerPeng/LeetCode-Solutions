package two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Integer> result = new ArrayList<>();
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
            // 2：通过count或其他限定值，得到一个可能解
            if (count == 0) result.add(left);
            // 3：只要窗口中有可能解，那么缩小窗口直到不包含可能解
            if (right - left == p.length() && map[sc[left++]]++ >= 0) count++;
        }
        return result;
    }

    public List<Integer> findAnagrams3(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return results;
        int[] chs = new int[26];
        for (char c : p.toCharArray()) chs[c - 'a']++;
        int left = 0;
        int right = 0;
        int count = p.length();
        while (right < s.length()) {
            // 子字符串区间长度满足要求
            if (right - left == p.length() && chs[s.charAt(left++) - 'a']++ >= 0) count++;
            // 先执行该句
            if (--chs[s.charAt(right++) - 'a'] >= 0) count--;
            // 三个字母完全对应上
            if (count == 0) results.add(left);
        }
        return results;
    }

    public List<Integer> findAnagrams4(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return results;
        // 保存目标字符串中字符与出现次数的映射
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        // 维持一个计数器来判断是否与目标字符串完全匹配，必须是Map的大小，而不是String的长度（因为字符有重复）
        int count = map.size();
        // 滑动窗口的左右指针，初始化一个长度为0的窗口
        int left = 0;
        int right = 0;
        // 直到right指针到达字符串末尾循环结束
        while (right < s.length()) {
            // 获取right指针对应字符
            char rightChar = s.charAt(right);
            // 每次有一个p中字符进入窗口，则count–-
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                // 匹配到一个字符，count--
                if (map.get(rightChar) == 0) count--;
            }
            // 扩展窗口，不断移动right指针
            right++;
            // 移动left指针，让子串再次有效/无效
            while (count == 0) {
                // 如果窗口大小刚好是目标字符串大小，并且count==0，表明我们的窗口中包含了p中的全部字符，因此可以添加结果
                if (right - left == p.length()) results.add(left);
                // 获取left指针对应字符
                char leftChar = s.charAt(left);
                // 表明一个在p中的字符就要移除窗口，则count ++
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    // 匹配到一个字符，count++
                    if (map.get(leftChar) > 0) count++;
                }
                // 不断移动left指针
                left++;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
        System.out.println(obj.findAnagrams4("cbaebabacd", "abc"));
        System.out.println(obj.findAnagrams4("abab", "ab"));
    }
}
// http://blog.csdn.net/cloudox_/article/details/53080159
// https://dyang2016.wordpress.com/2016/10/26/438-find-all-anagrams-in-a-string/