package heap;

import java.util.PriorityQueue;

/**
 * wait()和notify()方法的实现
 */
public class PubSub1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>(queueSize);

    public static void main(String[] args) {
        PubSub1 test1 = new PubSub1();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
        new Thread(test1.new Producer()).start();
        new Thread(test1.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                synchronized (LOCK) {
                    // 缓冲区满和为空时都调用wait()方法等待
                    while (count == FULL) {
                        try {
                            System.out.println("队列满，等待有空余空间");
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    // 每次插入一个元素
                    queue.offer(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                synchronized (LOCK) {
                    // 缓冲区满和为空时都调用wait()方法等待
                    while (count == 0) {
                        try {
                            System.out.println("队列空，等待数据");
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    // 每次移走队首元素
                    queue.poll();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}