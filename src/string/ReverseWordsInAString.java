package string;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string
 * 问题：翻转字符串中的单词
 * 思路：先整个字符串整体翻转一次，然后再分别翻转每一个单词
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        int storeIndex = 0, n = s.length();
        StringBuilder sb = new StringBuilder(s).reverse();
        for (int i = 0; i < n; ++i) {
            if (sb.charAt(i) != ' ') {
                if (storeIndex != 0) sb.setCharAt(storeIndex++, ' ');
                int j = i;
                while (j < n && sb.charAt(j) != ' ') sb.setCharAt(storeIndex++, sb.charAt(j++));
                String t = new StringBuilder(sb.substring(storeIndex - (j - i), storeIndex)).reverse().toString();
                sb.replace(storeIndex - (j - i), storeIndex, t);
                i = j;
            }
        }
        sb.setLength(storeIndex);
        return sb.toString();
    }

    public String reverseWordsAPI(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReverseWordsInAString obj = new ReverseWordsInAString();
        System.out.println(obj.reverseWords("the sky is blue"));
    }
}
// https://www.cnblogs.com/grandyang/p/4606676.html