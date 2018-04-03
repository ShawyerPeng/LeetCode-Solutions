package sword_for_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * https://www.nowcoder.com/questionTerminal/8fecd3f8ba334add803bf2a06af1b993
 * 问题：把数组排成最小的数
 * 思路：
 */
public class No33 {
    public String printMinNumber(int[] numbers) {
        if (numbers.length == 0 || numbers == null) return "";

        // 装箱处理，不然下面的Arrays.sort无法重写
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numbers[i];
        }

        Arrays.sort(nums, new Comparator<Integer>() {
            // 对数组nums用自定义方法排序
            @Override
            public int compare(Integer o1, Integer o2) {
                // 重写compare方法来比较o1,o2的大小，当o1+""+o2和o2+""+o1都是字符串，比较o1,o2的大小其实是比较两个子串的大小
                return (o1 + "" + o2).compareTo(o2 + "" + o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No33 obj = new No33();
        int[] nums = new int[]{3, 32, 321};
        System.out.println(obj.printMinNumber(nums));
    }
}
