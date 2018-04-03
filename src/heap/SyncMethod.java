package heap;

/**
 * Created by ShawyerPeng on 2018/3/24.
 */
public class SyncMethod {
    public synchronized void syncMethod2() {
        try {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ (syncMethod2, 已经获取内置锁`SyncMethod.this`)");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@ (syncMethod2, 即将释放内置锁`SyncMethod.this`)");
    }

    public synchronized void syncMethod1() {
        System.out.println("######################## (syncMethod1, 已经获取内置锁`SyncMethod.this`, 并即将退出)");
    }


    static class Thread1 extends Thread {
        SyncMethod syncMethod;

        public Thread1(SyncMethod syncMethod) {
            this.syncMethod = syncMethod;
        }

        @Override
        public void run() {
            syncMethod.syncMethod2();
        }
    }

    static class Thread2 extends Thread {
        SyncMethod syncMethod;

        public Thread2(SyncMethod syncMethod) {
            this.syncMethod = syncMethod;
        }

        @Override
        public void run() {
            System.out.println("Thread2 running ...");
            syncMethod.syncMethod1();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SyncMethod syncMethod = new SyncMethod();
        SyncMethod syncMethod2 = new SyncMethod();

        Thread1 thread1 = new Thread1(syncMethod);
        Thread2 thread2 = new Thread2(syncMethod);

        thread1.start();    //先执行, 以便抢占锁
        Thread.sleep(500); //放弃cpu, 让thread1执行, 以便获的锁

        thread2.start(); //在syncMethod1()方法获得锁时, 看看syncMethod2()方法能否执行

        /*
        能否并发执行同一个对象不同的synchronized方法, 即看看能否同时进入一个对象synchronized方法块

        1. 创建一个有两个synchronized方法的对象`syncMethod`
        2. 先启动一个线程(Thread1), 并让其进入syncMethod对象的sychronized方法(syncMethod1)内, 并使其停在synchronized方法内
        3. 再启动一个线程(Thread2), 并执行syncMethod对象的一个synchronized方法(syncMethod2), 看看能否进入此方法内

        输出如下:
        @@@@@@@@@@@@@@@@@@@@@@@@ (syncMethod2, 已经获取内置锁`SyncMethod.this`)
        Thread2 running ...
        @@@@@@@@@@@@@@@@@@@@@@@@ (syncMethod2, 即将释放内置锁`SyncMethod.this`)
        ######################## (syncMethod1, 已经获取内置锁`SyncMethod.this`, 并即将退出)

        结果分析:
            观察显示, 在输出`Thread2 running ...`后会暂停数秒(Thread2无法获得所而被挂起, 因为锁已经被Thread1持有).

            如果不同线程可以同时访问同一个对象不同synchronized方法的话,
            在有足够cpu时间片时(Thread1在调用syncMethod1时使用Thread.sleep放弃了cpu),
            Thread2调用的syncMethod2方法应该马上执行, 也就是syncMethod2方法中的语句在`Thread2 running ...`语句输出后马上输出,
            而不是等待数秒才输出 (应为此时没有其他线程跟Thread2竞争cpu, 况且现在的电脑都不只一个cpu),
            因此得出结论: "不同线程不能同时执行一个对象的不同synchronized方法"

            其实此结论是显而易见的, 原理前面已经阐明, 此处不再赘述.
        */

    }
}
