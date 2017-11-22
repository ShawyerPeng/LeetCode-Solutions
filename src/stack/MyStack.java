package stack;

import java.util.LinkedList;

public class MyStack<T> {
    // 双端队列
    private LinkedList<T> stack = new LinkedList<T>();

    /** 入栈 */
    public void push(T v) {
        // 将指定元素插入此列表的开头
        stack.addFirst(v);
    }

    /** 出栈，但不删除（获取栈顶元素） */
    public T peek() {
        // 返回此列表的第一个元素
        return stack.getFirst();
    }

    /** 出栈 */
    public T pop() {
        // 移除并返回此列表第一个元素
        return stack.removeFirst();
    }

    /** 栈是否为空 */
    public boolean empty() {
        // 判断栈空
        return stack.isEmpty();
    }

    /** 打印栈元素 */
    public String toString() {
        return stack.toString();
    }
}
