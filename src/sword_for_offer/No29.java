package sword_for_offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
 * 问题：数组中出现次数超过一半的数字
 * 思路：
 */
public class No29 {
    /**
     * 用HashMap
     */
    public int moreThanHalfNum(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = array.length;
        for (int i = 0; i < n; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
            if (map.get(array[i]) > n / 2) return array[i];
        }
        return 0;
    }

    /**
     * 排序
     */
    public int moreThanHalfNum2(int[] array) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[array.length / 2]) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return array[array.length / 2];
        } else {
            return 0;
        }
    }

    /**
     * 基于快排思想
     */
    public int moreThanHalfNum3(int[] array) {
        if (array.length <= 0) return 0;

        int start = 0;
        int length = array.length;
        int end = length - 1;
        int middle = length >> 1;

        int index = partition(array, start, end);

        while (index != middle) {
            if (index > middle) {
                index = partition(array, start, index - 1);
            } else {
                index = partition(array, index + 1, end);
            }
        }
        int result = array[middle];

        int times = 0;
        for (int i = 0; i < length; ++i) {
            if (array[i] == result)
                times++;
        }
        if (times * 2 < length) {
            System.out.println(times);
            return 0;
        } else {
            return result;
        }
    }

    private int partition(int[] array, int start, int end) {
        int flag = (array[start] + array[end]) / 2;
        while (start < end) {
            while (array[end] > flag) {
                end--;
            }
            swap(array, start, end);
            while (array[start] <= flag) {
                start++;
            }
            swap(array, start, end);
        }
        return start;
    }

    private void swap(int[] array, int num1, int num2) {
        int temp = array[num1];
        array[num1] = array[num2];
        array[num2] = temp;
    }

    /**
     * 基于数组特点
     */
    public int moreThanHalfNum4(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;

        for (int i = 0; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result)
                times++;
            else
                times--;
        }
        int time = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == result)
                time++;
        }
        if (time * 2 < array.length) {
            System.out.println(time);
            return 0;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        No29 obj = new No29();
        System.out.println(obj.moreThanHalfNum(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
// https://blog.csdn.net/u011489043/article/details/76422965