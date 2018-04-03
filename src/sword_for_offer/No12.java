package sword_for_offer;

import java.util.Arrays;

/**
 * 问题：打印1到最大的n位数
 * 思路：
 */
public class No12 {
    public void print1ToMaxOfNDigits(int n) {
        char[] number = new char[n+1];
        System.out.println(number);
        Arrays.fill(number, '0');
    }

    public static void main(String[] args) {
        No12 obj = new No12();
        obj.print1ToMaxOfNDigits(4);
    }
}
