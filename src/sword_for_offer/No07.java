package sword_for_offer;

import java.util.Stack;

/**
 * 问题：用两个栈实现队列。用两个栈来实现一个队列，完成队列的 Push 和 Pop 操作。 队列中的元素为 int 类型。
 * 思路：始终维护 s1 作为存储空间，以 s2 作为临时缓冲区。
 * 入队时，将元素压入 s1。
 * 出队时，将 s1 的元素逐个 “倒入”（弹出并压入）s2，将 s2 的顶元素弹出作为出队元素，之后再将 s2 剩下的元素逐个 “倒回”s1。
 */
public class No07 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     * 队列的 push() 操作，就直接在 stack1 上进行栈的 push() 操作即可
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 队列的 pop() 操作，其实就是得到 stack1 中最底下的那个元素，怎么得到呢？先把上面逐个退出的元素一个个放在另一个栈 stack2 中；
     * 当 stack1 为空的时候，stack2 的栈顶元素，就是要取得的元素，用栈的 pop() 操作取出
     * 在将该元素进行返回前，再将 stack2 中的元素倒回到 stack1 中，然后将该元素返回
     */
    public int pop() {
        // 如果stack2为空
        if (stack2.size() <= 0) {
            // 且stack1不为空
            while (stack1.size() > 0) {
                // 则不断把stack1中的元素pop出来，并push到stack2中暂存
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }
        // stack2的栈顶元素其实就是stack1的栈底元素，我们要pop队列的队首元素其实也就是pop栈的栈底元素
        int result = stack2.peek();
        stack2.pop();
        return result;
    }

    public static void main(String[] args) {
        No07 obj = new No07();
        obj.push(2);
        obj.push(3);
        System.out.println(obj.pop());
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}
// http://www.cnblogs.com/wanghui9072229/archive/2011/11/22/2259391.html