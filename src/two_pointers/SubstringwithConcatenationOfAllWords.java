package two_pointers;

import java.util.*;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words
 */
public class SubstringwithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return results;
        // 有n个单词
        int n = words.length;
        // 单词的长度
        int m = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - n * m; i++) {
            final Map<String, Integer> copy = new HashMap<>(map);
            int k = n;
            int j = i;
            while (k > 0) {
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) break;
                copy.put(str, copy.get(str) - 1);
                k--;
                j += m;
            }
            if (k == 0) results.add(i);
        }
        return results;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return results;
        // 单词的长度相同
        int wordLen = words[0].length();
        // 建立单词与出现次数的映射
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        // 因为不是一个字符，所以我们需要对源字符串所有长度为l的子串进行判断
        // i从0到l-1个字符开始，得到开始index分别为i, i+l, i+2*l, ...的长度为l的单词
        for (int i = 0; i < wordLen; i++) {
            int count = 0;
            // index of each startpoint
            int index = i;
            Map<String, Integer> curMap = new HashMap<>();
            // 直到最后一个单词的第一个字符
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                //
                String curWord = s.substring(j, j + wordLen);
                // 判断每个单词是否包含在Map中
                if (!map.containsKey(curWord)) {
                    curMap.clear();
                    count = 0;
                    index = j + wordLen;
                } else {
                    // form current dictionary
                    if (!curMap.containsKey(curWord))
                        curMap.put(curWord, 1);
                    else
                        curMap.put(curWord, curMap.get(curWord) + 1);

                    // count for current found word and check if it exceed given word count
                    if (curMap.get(curWord) <= map.get(curWord)) {
                        count++;
                    } else {
                        while (curMap.get(curWord) > map.get(curWord)) {
                            String temp = s.substring(index, index + wordLen);
                            curMap.put(temp, curMap.get(temp) - 1);
                            // make index move next
                            index = index + wordLen;
                        }
                    }

                    //put into res and move index point to nextword
                    //and update current dictionary as well as count num
                    if (count == words.length) {
                        results.add(index);
                        String temp = s.substring(index, index + wordLen);
                        curMap.put(temp, curMap.get(temp) - 1);
                        index = index + wordLen;
                        count--;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        SubstringwithConcatenationOfAllWords obj = new SubstringwithConcatenationOfAllWords();
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
        System.out.println(obj.findSubstring(s, words));
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = new String[]{"word", "good", "best", "good"};
        System.out.println(obj.findSubstring(s2, words2));
    }
}
// http://blog.csdn.net/linhuanmars/article/details/20342851
// http://www.cnblogs.com/grandyang/p/4521224.html