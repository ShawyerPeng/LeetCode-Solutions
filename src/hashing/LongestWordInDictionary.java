package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary
 */
public class LongestWordInDictionary {
    public static String longestWord(String[] words) {
        Set<String> dict = new HashSet<>();
        Collections.addAll(dict, words);

        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        // 自定义排序规则
        Collections.sort(wordList, (a, b) -> {
            // 从小到大排序
            if (b.length() != a.length()) {
                return b.length() - a.length();
            } else {
                // 从大到小排序
                return a.compareTo(b);
            }
        });

        for (int i = words.length - 1; i >= 0; i--) {
            if (buildWord(dict, words[i])) {
                return words[i];
            }
        }

        return "";
    }

    private static boolean buildWord(Set<String> dict, String word) {
        for (int i = 1; i < word.length(); i++) {
            if (!dict.contains(word.substring(0, i))) {
                return false;
            }
        }
        // 可以拆分
        return true;
    }

    public static String longestWord2(String[] words) {
        Set<String> wordset = new HashSet();
        for (String word : words) wordset.add(word);
        Arrays.sort(words, (a, b) -> a.length() == b.length()
                ? a.compareTo(b) : b.length() - a.length());
        for (String word : words) {
            boolean good = true;
            for (int k = 1; k < word.length(); ++k) {
                if (!wordset.contains(word.substring(0, k))) {
                    good = false;
                    break;
                }
            }
            if (good) return word;
        }

        return "";
    }

    public static void main(String[] args) {
        String[] words1 = new String[]{"w", "wo", "wor", "worl", "world"};
        System.out.println(longestWord(words1));
        String[] words2 = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(longestWord(words2));
        String[] words3 = new String[]{"b", "br", "bre", "brea", "break", "breakf", "breakfa", "breakfas", "breakfast", "l", "lu", "lun", "lunc", "lunch", "d", "di", "din", "dinn", "dinne", "dinner"};
        System.out.println(longestWord(words3));
    }
}
// https://www.youtube.com/watch?v=BpkEnyfJUag
// https://leetcode.com/articles/longest-word-in-dictionary/
// https://hzhou.me/LeetCode/LeetCode-Longest-Word-in-Dictionary.html