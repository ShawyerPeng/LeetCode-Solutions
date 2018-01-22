package design;

/**
 * 静态方法（类）同步。
 * 对静态方法的同步本质上是对类的同步（静态方法本质上是属于类的方法，而不是对象上的方法）
 * 所以即使 test 和 test2 属于不同的对象，但是它们都属于 SynchronizedTest 类的实例，所以也只能顺序的执行 method1 和 method2，不能并发执行。
 */
public class SynchronizedTest3 {
    public static synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public static synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }

    public static void main(String[] args) {
        final SynchronizedTest test = new SynchronizedTest();
        final SynchronizedTest test2 = new SynchronizedTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test2.method2();
            }
        }).start();
    }
}
