package sword_for_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/questionTerminal/1c82e8cf713b4bbeb2a5b31cf5b0417c
 * 问题：第一个只出现一次的字符
 * 思路：
 */
public class No35 {
    public int firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // key为字符，value为出现的次数
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        No35 obj = new No35();
        System.out.println(obj.firstNotRepeatingChar("google"));
    }
}
