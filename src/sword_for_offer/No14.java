package sword_for_offer;

import java.util.Arrays;

/**
 * 问题：
 * 思路：
 */
public class No14 {
    /**
     * 不能保证相对位置不变
     */
    public void reorderOddEven(int[] nums) {
        if (nums == null || nums.length < 2) return;

        int p1 = 0, p2 = nums.length - 1;
        while (p1 < p2) {
            // 向后移动p1，直到它指向偶数
            while (p1 < p2 && !isEven(nums[p1])) p1++;
            // 向前移动p2，直到它指向奇数
            while (p1 < p2 && isEven(nums[p2])) p2--;
            // 交换
            if (p1 < p2) {
                int temp = nums[p1];
                nums[p1] = nums[p2];
                nums[p2] = temp;
            }
        }
    }

    /**
     * 判断是不是偶数
     */
    private boolean isEven(int n) {
        return (n & 1) == 0;
    }

    /**
     * 能保证相对位置不变
     */
    public void reorderOddEven3(int[] nums) {
        if (nums == null || nums.length < 2) return;

        for (int oddIndex = 0, evenIndex = 0; oddIndex < nums.length && evenIndex < nums.length; ) {
            if ((nums[evenIndex] & 1) != 0) {
                evenIndex++;
                oddIndex = evenIndex;
                continue;
            }
            if ((nums[oddIndex] & 1) == 0) {
                oddIndex++;
                continue;
            }
            int temp = nums[oddIndex];
            nums[oddIndex] = nums[evenIndex];
            nums[evenIndex] = temp;
            oddIndex++;
            evenIndex++;
        }
    }

    public void reorderOddEven2(int[] nums) {
        if (nums == null || nums.length < 2) return;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 != 0) {
                        int temp = nums[j];
                        for (int k = j; k > i; k--) {
                            nums[k] = nums[k - 1];
                        }
                        nums[i] = temp;
                    }
                    // 如果j找到了第一个奇数就执行break，否则继续找，因为若没有找到i后面第一个奇数，nums[i]的值是偶数，并没有被改变，当然if判断里面也可以是if(nums[j]%2==0)等
                    if (nums[i] % 2 != 0) {
                        // 这里break的目的是为了j找到第一个奇数后，挪动了相应的元素后退出第二处for循环，而不是依次执行下去
                        //如果是直接是break没有if判断，就会有问题，因为会导致j第一次没有找到奇数就退出了
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        No14 obj = new No14();
        int[] nums = new int[]{1, 4, 7, 5, 8, 9, 3, 1, 0};
        obj.reorderOddEven(nums);
        System.out.println(Arrays.toString(nums));
    }
}
