package heap;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class DownloadThread extends Thread {
    private CyclicBarrier barrier;
    private int threadId;
    private Connection conn;
    private int startPos;
    private int endPos;
    private String filePath;


    public DownloadThread(CyclicBarrier barrier, int threadId, Connection conn, int startPos, int endPos, String filePath) {
        super();
        this.barrier = barrier;
        this.threadId = threadId;
        this.conn = conn;
        this.startPos = startPos;
        this.endPos = endPos;
        this.filePath = filePath;
    }


    @Override
    public void run() {
        try {
            byte[] buffer = conn.read(startPos, endPos);
            System.out.println("---ThreadId---: " + threadId + " start download !");
            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");

            raf.seek(startPos);

            raf.write(buffer);

            raf.close();
            System.out.println("---ThreadId---: " + threadId + " download succssed !");
            barrier.await();

        } catch (IOException | BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}