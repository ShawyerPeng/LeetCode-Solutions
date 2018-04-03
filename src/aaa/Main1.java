package aaa;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int i = 0;
        while (i < n) {
            nums[i] = in.nextInt();
            i++;
        }

        // 使用两个指针遍历数组，一个指向数值为0的元素，另一个指向数值不为0的元素，在遍历的过程中，不断交换两个指针的值。
        for (int zeroIndex = 0, noneZeroIndex = 0; noneZeroIndex < nums.length && zeroIndex < nums.length; ) {
            // 零指针不断往后移，直到遇到0元素
            if (nums[zeroIndex] != 0) {
                zeroIndex++;
                // 非零指针在零指针之后
                noneZeroIndex = zeroIndex;
                continue;
            }
            // 非零指针不断往后移，直到遇到非0元素
            if (nums[noneZeroIndex] == 0) {
                noneZeroIndex++;
                continue;
            }
            // 交换两者的值
            int temp = nums[zeroIndex];
            nums[zeroIndex] = nums[noneZeroIndex];
            nums[noneZeroIndex] = temp;
            zeroIndex++;
            noneZeroIndex++;
        }

        for (i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
        System.out.println(Arrays.toString(nums));
    }
}