package sword_for_offer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.nowcoder.com/questionTerminal/6aa9e04fc3794f68acf8778237ba065b
 * 问题：丑数
 * 思路：
 */
public class No34 {
    public int getUglyNumber(int index) {
        if (index < 7) return index;
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int t2 = 0, t3 = 0, t5 = 0, i;
        for (i = 1; i < index; ++i) {
            res.add(i, Math.min(res.get(t2) * 2, Math.min(res.get(t3) * 3, res.get(t5) * 5)));
            if (res.get(i) == res.get(t2) * 2) t2++;
            if (res.get(i) == res.get(t3) * 3) t3++;
            if (res.get(i) == res.get(t5) * 5) t5++;
        }
        return res.get(index - 1);
    }

    public static void main(String[] args) {
        No34 obj = new No34();
        System.out.println(obj.getUglyNumber(1500));
    }
}
