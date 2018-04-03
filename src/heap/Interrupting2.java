//package heap;
//
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.LockSupport;
//import java.util.concurrent.locks.ReentrantLock;
//
//class BlockedMutex {
//    private Lock lock = new ReentrantLock();
//
//    public BlockedMutex() {
//        this.lock.lock();// main线程持有了这个锁
//        System.out.println(Thread.currentThread().getName());
//    }
//
//    public void f() {
//        try {
//            LockSupport
//            this.lock.lockInterruptibly();// 如果当前线程未被中断则获取锁
//            System.out.println("lock acquired in f()");
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted from lock acquisition in f()");
//        }
//        System.out.println(Thread.currentThread().getName() + " run.");
//    }
//}
//
//class Blocked2 implements Runnable {
//    BlockedMutex blocked = new BlockedMutex();
//
//    @Override
//    public void run() {
//        System.out.println("Waiting for f() in BlockedMutex");
//        this.blocked.f();
//        System.out.println("Broken out of blocked call");
//        System.out.println(Thread.currentThread().getName());
//    }
//}
//
//public class Interrupting2 {
//    public static void main(String[] args) throws InterruptedException {
//        Thread t = new Thread(new Blocked2());
//        t.start();
//        TimeUnit.SECONDS.sleep(1);
//        System.out.println(t.isInterrupted());
//        //t.interrupt();
//        System.out.println(t.isInterrupted());
//        Thread.sleep(3000);
//    }
//}
