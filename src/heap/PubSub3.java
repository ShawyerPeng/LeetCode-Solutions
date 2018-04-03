package heap;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列BlockingQueue的实现
 */
public class PubSub3 {
    private static Integer count = 0;
    //创建一个阻塞队列
    final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        PubSub3 test = new PubSub3();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }

    class Producer implements Runnable {
        private volatile boolean flag;

        @Override
        public void run() {
            while (!flag) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产一个元素，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutDown() {
            flag = true;
        }
    }

    class Consumer implements Runnable {
        private volatile boolean flag;

        @Override
        public void run() {
            while (!flag) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shutDown() {
            flag = true;
        }
    }
}