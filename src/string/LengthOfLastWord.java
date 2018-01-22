package string;

/**
 * https://leetcode.com/problems/length-of-last-word
 * 问题：找出最后一个单词的长度。
 * 思路：从后往前看字符串，跳过所有空格后，记下该结束位置，再到下一个空格，再记录一个开始位置，则长度就是结束位置减去开始位置。
 * 在跳过空格的循环后，要判断是否已经超界，如果超界则返回 0
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int idx = s.length() - 1;
        // 跳过末尾的空格
        while (idx >= 0) {
            if (s.charAt(idx) != ' ') break;
            idx--;
        }
        // 记录结束位置
        int end = idx;
        // 如果已经超界返回0
        if (idx < 0) return 0;
        // 找到开始位置
        while (idx >= 0) {
            if (s.charAt(idx) == ' ') break;
            idx--;
        }
        return end - idx;
    }

    public int lengthOfLastWordAPI(String s) {
        return s.trim().split(" +")[s.trim().split(" +").length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord("Hello World"));
    }
}
// https://segmentfault.com/a/1190000003871916