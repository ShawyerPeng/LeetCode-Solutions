package stack;

import java.util.LinkedList;

public class MinStack {
    private LinkedList<Integer> list; // 存储压入栈中的所有值
    private LinkedList<Integer> mins; // 存储当前栈中的最小值

    public MinStack() {
        list = new LinkedList<Integer>();
        mins = new LinkedList<Integer>();
    }

    public void push(int x) {
        // 如果最小值栈中没有值，或者当前元素x比最小值栈中的最小值还要小，则把x放入最小值栈中
        if (mins.size() < 1 || mins.getLast() >= x) {
            mins.add(x);
        }
        list.add(x);

    }

    public void pop() {
        // pop 的时候，有可能 pop 出的是当前栈中的最小值。因此在 pop 函数操作时，需同时操作维护最小值的 linkedlist
        if (list.getLast().equals(mins.getLast())) {
            mins.removeLast();
        }
        list.removeLast();
    }

    public int top() {
        return list.getLast();
    }

    public int getMin() {
        return mins.getLast();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }
}
// http://blademastercoder.github.io/2015/02/05/leetcode-MinStack.html