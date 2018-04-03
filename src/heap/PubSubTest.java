package heap;

import java.util.ArrayList;

public class PubSubTest {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new ProductThread().start();
        for (int i = 0; i < 3; i++) {
            new ConsumerThread().start();
        }
    }

    private static class ProductThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (lock) {
                    if (Res.list.size() != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Res.list.add("h");
                    System.out.println(getName() + ": 生产者生产一个元素");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            }
        }
    }

    private static class ConsumerThread extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                synchronized (lock) {
                    while (Res.list.size() == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Res.list.remove(0);
                    System.out.println(getName() + ": 消费者消费一个元素");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notifyAll();
                }
            }
        }
    }

    private static class Res {
        static ArrayList<String> list = new ArrayList<>();
    }
}
