package two_pointers;

import java.util.*;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words
 */
public class SubstringwithConcatenationOfAllWords {
    /**
     * 代码暂时有问题
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return results;

        // length of each word
        int size = words[0].length();

        for (int i = 0; i <= s.length() - size * words.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                // words有可能重复
                map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1);
            }

            // checkc if match
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j * size, i + j * size + size);
                int count = map.get(str);
                if (map.containsKey(str)) {
                    if (count == 1) {
                        map.remove(str);
                    } else {
                        map.put(str, count - 1);
                    }
                    // matches
                    if (map.isEmpty()) {
                        results.add(i);
                        break;
                    }
                } else {
                    // 不在words中
                    break;
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        System.out.println(findSubstring(s, words));
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = new String[]{"word", "good", "best", "good"};
        System.out.println(findSubstring(s2, words2));
    }
}
// http://blog.csdn.net/linhuanmars/article/details/20342851
// http://www.cnblogs.com/grandyang/p/4521224.html