package hashing;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal
 * 问题：给定两个整数代表分数的分子和分母，返回字符串形式的小数。如果小数部分是循环的，用括号将循环节围起来。
 * 思路：
 */
public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        if (num == 0 || den == 0) {
            return "0";
        }
        // 判断结果正负号
        boolean negative = (num > 0 && den < 0) || (num < 0 && den > 0);
        num = Math.abs(num);
        den = Math.abs(den);
        // 得到整数部分
        String integ = (negative ? "-" : "") + String.valueOf(num / den);
        // 如果存在小数部分
        if (num % den != 0) {
            num = num % den;
            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            int pos = 0;
            map.put(num, pos);
            StringBuilder frac = new StringBuilder();
            // 计算小数部分
            while (num != 0) {
                // 先把算出的小数加上，再判断余数是否重复，如果余数重复的话，小数会从下一个开始重复
                num = num * 10;
                frac.append(num / den);
                num = num % den;
                // 如果该余数之前出现过，说明有循环，上次出现的位置到当前位置就是循环的部分
                if (map.containsKey(num)) {
                    // 将非循环部分和循环部分分开
                    String pre = frac.substring(0, map.get(num));
                    String loop = frac.substring(map.get(num));
                    // 返回有循环的结果
                    return integ + "." + pre + "(" + loop + ")";
                }
                pos++;
                // 记录下当前余数和他对应小数的位置
                map.put(num, pos);
            }
            // 返回无循环有小数的结果
            return integ + "." + frac.toString();
        }
        // 返回无小数的结果
        return integ;
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 3));
        System.out.println(fractionToDecimal(3, 4));
    }
}
// https://segmentfault.com/a/1190000003794677
// http://bookshadow.com/weblog/2014/12/17/leetcode-fraction-recurring-decimal/