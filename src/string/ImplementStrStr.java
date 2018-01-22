package string;

/**
 * https://leetcode.com/problems/implement-strstr
 * 问题：
 * 思路：
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        int start = 0;
        // 如果剩下的字母不够needle长度就停止遍历
        while (start <= haystack.length() - needle.length()) {
            int i1 = start, i2 = 0;
            while (i2 < needle.length() && haystack.charAt(i1) == needle.charAt(i2)) {
                i1++;
                i2++;
            }
            if (i2 == needle.length()) return start;
            start++;
        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr obj = new ImplementStrStr();
        System.out.println(obj.strStr("hello", "ll"));
        System.out.println(obj.strStr("aaaaa", "bba"));
    }
}
// https://segmentfault.com/a/1190000003707284