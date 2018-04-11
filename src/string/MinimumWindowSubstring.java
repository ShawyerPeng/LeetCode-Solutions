package string;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/minimum-window-substring
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        String res = "";
        // 已经匹配的字符个数
        int matchCount = 0;
        // 记录T中每个字符出现的次数（不变）
        int[] tArr = new int[256];
        for (char c : t.toCharArray()) tArr[c]++;
        // 记录S中每个字符出现的次数
        int[] sArr = new int[256];
        // 从0开始找到第一个有效的字符，也就是说，这个字符必须是在T中才行
        int left = findNextStrIdx(0, s, tArr);
        int right = left;
        if (left == s.length()) return "";
        // right指针移动到字符串末尾时退出循环
        while (right < s.length()) {
            int rightChar = s.charAt(right);
            // 如果sArr中该字符的数量小于tArr中该字符的数量，matchCount++
            if (sArr[rightChar] < tArr[rightChar]) matchCount++;
            // sArr中对应字符的数量也加一
            sArr[rightChar]++;
            // 如果已经找到了一个有效的SubString，就让left指针往右移
            while (left < s.length() && matchCount == t.length()) {
                // 现在找到的SubString比原来找到的要短，就更新结果
                if (res.isEmpty() || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
                int leftChar = s.charAt(left);
                // 如果某个字符出现次数超过tArr的要求，matchCount--
                if (sArr[leftChar] <= tArr[leftChar]) {
                    matchCount--;
                }
                // sArr中对应字符的数量也减一
                sArr[leftChar]--;
                // left移动到下一个有效字符
                left = findNextStrIdx(left + 1, s, tArr);
            }
            // 退出循环说明当前的SubString不是有效的了，需要right移动到下一个有效字符，直到重新找到一个有效的SubString
            right = findNextStrIdx(right + 1, s, tArr);
        }
        return res;
    }

    /**
     * 寻找有效的字符
     */
    private int findNextStrIdx(int start, String s, int[] tArr) {
        while (start < s.length()) {
            // 如果start移动到某个位置对应字符包含在T中，就返回start，即找到一个有效字符
            if (tArr[s.charAt(start)] != 0) return start;
            start++;
        }
        return start;
    }

    public String minWindow2(String s, String t) {
        if (s == null || s.length() < t.length() || t.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        // 统计T中每个字符出现的次数
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        // 当前最短的满足要求的子串的起始位置
        int minLeft = 0;
        // 当前最短的满足要求的子串的长度
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                char r = s.charAt(right);
                map.put(r, map.get(r) - 1);
                if (map.get(r) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    // 如果当前长度小于之前的minLen，就更新minLeft和minLen
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    char l = s.charAt(left);
                    if (map.containsKey(l)) {
                        map.put(l, map.get(l) + 1);
                        if (map.get(l) > 0) count--;
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) return "";
        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }
}
