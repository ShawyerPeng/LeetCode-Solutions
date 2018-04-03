package sword_for_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7
 * 问题：字符串的排列
 * 思路：
 */
public class No28 {
    public List<String> permutation(String str) {
        List<String> results = new ArrayList<>();
        if (str == null || str.length() == 0) return results;

        PermutationHelper(str.toCharArray(), 0, results);
        Collections.sort(results);

        return results;
    }

    //private void helper(List<String> results, StringBuilder sb, char[] chs) {
    //    if (sb.length() == chs.length) {
    //        results.add(sb.toString());
    //        return;
    //    }
    //
    //    for (int i = 0; i < chs.length; i++) {
    //        if (sb.indexOf(String.valueOf(chs[i])) == null) {
    //            continue;
    //        }
    //        sb.append(chs[i]);
    //        helper(results, sb, chs);
    //        sb.deleteCharAt(sb.length() - 1);
    //    }
    //}

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        No28 obj = new No28();
        System.out.println(obj.permutation("abc"));
    }
}
