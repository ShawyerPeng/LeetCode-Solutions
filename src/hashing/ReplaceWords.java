package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/replace-words
 * 问题：给了我们一个前缀字典，将句子中较长的单词换成其前缀
 * 思路：用一个 hashset 存储缩写 list 中的元素，把 sentence 通过 split(” “) 分割成单词 array，
 * 逐个单词对应查找其缩写并转换成其缩写，再把缩写后的单词 array 合成 sentence 并返回。
 */
public class ReplaceWords {
    public static String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>();
        set.addAll(dict);
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (set.contains(words[i].substring(0, j))) {
                    words[i] = words[i].substring(0, j);
                }
            }
        }
        String replacedWord = "";
        for (int i = 0; i < words.length; i++)
            replacedWord += (words[i] + " ");
        return replacedWord.substring(0, replacedWord.length() - 1);
    }

    public static void main(String[] args) {
        String[] dicts = new String[]{"cat", "bat", "rat"};
        List<String> dict = new ArrayList<>(Arrays.asList(dicts));
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));
    }
}
// http://blog.csdn.net/marlonlyh/article/details/76100922