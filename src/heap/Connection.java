package heap;

import java.io.IOException;

/**
 * 封装Connection
 */
public interface Connection {
    /**
     * 给定开始和结束位置， 读取数据， 返回值是字节数组
     */
    byte[] read(int startPos, int endPos) throws IOException;

    /**
     * 得到数据内容的长度
     */
    int getContentLength();

    /**
     * 关闭连接
     */
    void close();
}