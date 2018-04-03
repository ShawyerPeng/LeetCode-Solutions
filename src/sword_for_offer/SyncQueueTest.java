//package sword_for_offer;
//
//import java.util.concurrent.*;
//
//public class SyncQueueTest {
//    private static ExecutorService executor = new ThreadPoolExecutor(1, 1,
//            1000, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.DiscardPolicy());
//
//    ExecutorService executor =  Executors.newSingleThreadExecutor();
//
//    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 20; i++) {
//            kickOffEntry(i);
//            Thread.sleep(200);
//        }
//
//        executor.shutdown();
//    }
//
//    private static void kickOffEntry(final int index) {
//        executor.submit(new Callable<Void>() {
//                    public Void call() throws InterruptedException {
//                        System.out.println("start " + index);
//                        Thread.sleep(1000); // pretend to do work
//                        System.out.println("stop " + index);
//                        return null;
//                    }
//                }
//        );
//    }
//}