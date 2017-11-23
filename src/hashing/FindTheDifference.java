package hashing;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-the-difference
 * 问题：有两个字符串 S 和 T，T 是 S 打乱后多加一个字符，要找出这个不同的字符来
 * 思路：
 */
public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        Character[] chars = new Character[s.length()];
        // 转换为Character数组
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        // 转换为Character List
        List charList = Arrays.asList(chars);
        // 依次变量判断
        for (int i = 0; i < t.length(); i++) {
            if (!charList.contains(t.charAt(i))) {
                return t.charAt(i);
            }
        }
        throw new IllegalArgumentException("no other letter was added.");
    }

    public static char findTheDifferenceBit(String s, String t) {
        char answer = 0x00;
        for (int i = 0; i < s.length(); i++) {
            answer ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            answer ^= t.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abdcde"));
    }
}
// http://zhangchuzhao.site/2016/08/27/LeetCode-389-find-the-difference/