package sword_for_offer;

import java.util.List;
import java.util.Stack;

/**
 * https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49
 * 问题：包含min函数的栈
 * 思路：
 */
public class No21 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (!stack2.empty())
            stack2.push(Math.min(stack2.peek(), node));
        else
            stack2.push(node);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        No21 obj = new No21();
        obj.push(4);
        obj.push(7);
        obj.push(3);
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
    }
}
