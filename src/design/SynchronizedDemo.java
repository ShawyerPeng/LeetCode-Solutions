package design;

/**
 * Created by ShawyerPeng on 2017/12/4.
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }

    public synchronized void method2() {
        System.out.println("Method 1 start");
    }
}
