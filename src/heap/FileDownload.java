package heap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.CyclicBarrier;

public class FileDownload {
    DownloadListener listener;
    ConnectionManager cm;
    String url = "";
    String filePath = "";
    private static final int THREAD_NUM = 3;
    long interruptPos;

    /**
     * 1.获取URL建立链接
     * 2.获取文件长度建立临时文件
     * 3.分段下载，若中断 则seek续传
     */
    public FileDownload(String url) {
        this.url = url;
    }

    public void excute() {
        CyclicBarrier barrier = new CyclicBarrier(THREAD_NUM, new Runnable() {
            @Override
            public void run() {
                listener.notifyFinished();
            }
        });
        try {
            Connection conn = cm.open(url);

            int length = conn.getContentLength();

            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
            System.out.println("----创建临时文件----");
            raf.write(length);
            raf.close();
            System.out.println("----文件大小----: " + length);
            int block = length % THREAD_NUM == 0 ? length / THREAD_NUM : length / THREAD_NUM + 1;

            for (int threadId = 0; threadId < THREAD_NUM; threadId++) {
                int startPos = threadId * block;
                int endPos = (threadId + 1) * block - 1;
                new DownloadThread(barrier, threadId, cm.open(url), startPos, endPos, filePath).start();
                ;
            }

        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getDownloadTime(long end, long start) {
        System.out.println("下载耗时 :" + (end - start) / 1000 + "秒");
    }

    public DownloadListener getListener() {
        return listener;
    }

    public void setListener(DownloadListener listener) {
        this.listener = listener;
    }

    public String getFilePath() {
        return filePath;
    }


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public ConnectionManager getCm() {
        return cm;
    }

    public void setCm(ConnectionManager cm) {
        this.cm = cm;
    }

    boolean downloadFinished = false;


    public static void main(String[] args) {
        final boolean[] downloadFinished = {false};
        String url = "http://down.360safe.com/yunpan/360wangpan_setup.exe";
        FileDownload down = new FileDownload(url);

        ConnectionManager cm = new ConnectionManagerHttp();

        down.setCm(cm);
        down.setFilePath("yunpan.exe");
        down.setListener(new DownloadListener() {
            @Override
            public void notifyFinished() {
                downloadFinished[0] = true;
            }
        });

        down.excute();

        while (!downloadFinished[0]) {
            try {
                System.out.println("还没有下载完成，休眠五秒");
                //休眠5秒
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("下载完成!");
    }
}