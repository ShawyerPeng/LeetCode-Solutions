package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * 问题：电话号码组合
 * 思路：首先建一个表，来映射号码和字母的关系。然后对号码进行深度优先搜索，对于每一位，从表中找出数字对应的字母，这些字母就是本轮搜索的几种可能。
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) return results;

        dfs(0, new StringBuilder(), digits, results);

        return results;
    }

    private void dfs(int index, StringBuilder path, String digits, List<String> results) {
        // 映射号码和字母的关系，2-9键对应的字母
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // 找到一种结果，加入列表中
        if (index == digits.length()) {
            results.add(path.toString());
            return;
        }

        // 某个index对应的数字
        int number = digits.charAt(index) - '0';
        // 该数字对应的字母集
        String val = dict[number - 2];
        for (int i = 0; i < val.length(); i++) {
            // 找出当前位数字对应可能的字母
            path.append(val.charAt(i));
            dfs(index + 1, path, digits, results);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber obj = new LetterCombinationsOfAPhoneNumber();
        System.out.println(obj.letterCombinations("23"));
    }
}
// https://segmentfault.com/a/1190000003766442