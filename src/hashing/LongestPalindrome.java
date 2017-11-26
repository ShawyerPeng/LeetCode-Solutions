package hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindrome
 * 问题：给定一个只包含小写或者大写字母的字符串，寻找用这些字母可以组成的最长回文串的长度。
 * 大小写敏感，例如 "Aa" 在这里不认为是一个回文。
 * 思路：统计每个字母的出现次数：
 * 若字母出现偶数次，则直接累加至最终结果
 * 若字母出现奇数次，则将其值 - 1 之后累加至最终结果
 * 若存在出现奇数次的字母，将最终结果 + 1
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            // 偶数个字符直接累加至结果并remove
            if ((Integer) entry.getValue() % 2 == 0) {
                length += (Integer) entry.getValue();
                // 注意不能在迭代中使用map.remove()，否则抛出ConcurrentModificationException异常
                it.remove();
            } else {
                length += ((Integer) entry.getValue()) - 1;
                map.put((Character) entry.getKey(), 1);
            }
        }

        // 此时没有偶数个的字符了，如果还存在有一个的字符，则+1
        it = map.entrySet().iterator();
        if (it.hasNext()) {
            length += 1;
        }

        return length;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("ccc"));
    }
}
// http://www.cnblogs.com/grandyang/p/5931874.html