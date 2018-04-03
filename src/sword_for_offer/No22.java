package sword_for_offer;

import java.util.Stack;

/**
 * https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
 * 问题：栈的压入、弹出序列
 * 思路：
 */
public class No22 {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0) return false;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; ) {
            stack.push(pushA[i++]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        No22 obj = new No22();
        System.out.println(obj.isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(obj.isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
