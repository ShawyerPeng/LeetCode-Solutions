package template;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 数字分开位数
 */
public class DivideNumber {
    public static int[] divide(int num) {
        ArrayList<Integer> results = new ArrayList<>();
        int count = 0;
        int x = num;
        int pow;
        // 判断几位数
        while (x > 0) {
            x = x / 10;
            count++;
        }
        // 分割每位数字
        for (int i = count; i > 0; i--) {
            pow = 1;
            for (int j = 1; j < i; j++) {
                pow = 10 * pow;
            }
            int digit = (num / pow) % 10;
            results.add(digit);
        }

        int[] res = new int[results.size()];
        for (int i = 0; i < results.size(); i++)
            res[i] = results.get(i);
        return res;
    }

    public static int[] divideString(int num) {
        ArrayList<Integer> results = new ArrayList<>();

        String number = Integer.toString(num);
        char[] nums = number.toCharArray();
        for (int i = 0; i < nums.length; i++) {
            results.add(nums[i] - '0');
        }

        int[] res = new int[results.size()];
        for (int i = 0; i < results.size(); i++)
            res[i] = results.get(i);
        return res;
    }

    public static int[] divideRec(int n) {
        ArrayList<Integer> results = new ArrayList<>();
        if (n > 0) {
            divideRec(n / 10);
            n = n % 10;
            results.add(n);
        }

        int[] res = new int[results.size()];
        for (int i = 0; i < results.size(); i++)
            res[i] = results.get(i);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(DivideNumber.divide(123456789)));
        System.out.println(Arrays.toString(DivideNumber.divideString(123456789)));
        //System.out.println(Arrays.toString(DivideNumber.divideRec(123456789)));
    }
}
