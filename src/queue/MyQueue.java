package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private Queue<T> queue = new LinkedList<T>();

    /** 将指定的元素插入队尾 */
    public void offer(T v) {
        queue.offer(v);
    }

    /** 检索，但是不移除队列的头，如果此队列为空，则返回 null */
    public T peek() {
        return queue.peek();
    }

    /** 检索，但是不移除此队列的头 */
    /** 此方法与 peek 方法的惟一不同是，如果此队列为空，它会抛出一个异常 */
    public T element() {
        return queue.element();
    }

    /** 检索并移除此队列的头，如果队列为空，则返回 null */
    public T poll() {
        return queue.poll();
    }

    /** 检索并移除此队列的头 */
    /** 此方法与 poll 方法的不同在于，如果此队列为空，它会抛出一个异常 */
    public T remove() {
        return queue.remove();
    }

    /** 队列是否为空 */
    public boolean empty() {
        return queue.isEmpty();
    }

    /** 打印队列元素 */
    public String toString() {
        return queue.toString();
    }
}
