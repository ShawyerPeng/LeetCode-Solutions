package hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/keyboard-row
 * 题目：
 * 思路：1. 用 Map 存储字母到所在行的映射
 * 2. 变量 words，对每一个单词，先做小写字母转换存入 word，再对 word 的每个字母进行遍历。
 * 用 flag 标记是否是第一个字母，用 row 存储第一个字母所在的行，对后续的字母，判断其所在行是否等于 row，若不是，直接跳出内层循环继续判断下一个单词。
 * 考虑到数组需要预先设置长度，而数组长度未知，所以判断整个单词完毕后将其县存入 List，最后再把 List 的元素存入结果数组
 */
public class KeyboardRow {
    public static String[] findWords(String[] words) {
        List<String> results = new ArrayList<>();
        char[] row1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
        char[] row2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
        char[] row3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : row1) {
            map.put(ch, 1);
        }
        for (Character ch : row2) {
            map.put(ch, 2);
        }
        for (Character ch : row3) {
            map.put(ch, 3);
        }

        for (String word : words) {
            int row = map.get(word.toCharArray()[0]);
            Boolean flag = true;
            for (Character character : word.toCharArray()) {
                if (map.get(character) != row) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                results.add(word);
        }

        int size = results.size();
        return results.toArray(new String[size]);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        String[] strs = findWords(strings);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
// http://blog.csdn.net/zhouziyu2011/article/details/54907270