package hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number
 * 问题：对于某一个正整数，如果对其各个位上的数字分别平方，然后再加起来得到一个新的数字，再进行同样的操作，如果最终结果变成了 1，则说明是快乐数，
 * 如果一直循环但不是 1 的话，就不是快乐数
 * 思路：我们很难在有限步骤内确定一个数是否是快乐数，但使用排除法的话，我们可以尝试确定一个数不是快乐数。
 * 根据题意，当计算出现无限循环的时候就不是快乐数。出现无限循环的说明产生了相同的结果，而判断相同结果只要用 Set 就行了。
 * Follow Up：
 * Q: 可不可以不用 HashTable 或者 HashSet 解决这题？
 * A: 可以，参考 Linked List Cycle，我们可以记录下每轮产生的结果，同时用快慢指针遍历，一旦快慢指针相与便说明有环。
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
