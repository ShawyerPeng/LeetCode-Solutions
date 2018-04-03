package heap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * 链接类
 */
public class ConnectionHttp implements Connection {
    private HttpURLConnection httpConn;

    public ConnectionHttp(HttpURLConnection httpConn) {
        this.httpConn = httpConn;
    }

    @Override
    public byte[] read(int startPos, int endPos) throws IOException {
        httpConn.addRequestProperty("Range", "bytes=" + startPos + "-" + endPos);
        InputStream is = httpConn.getInputStream();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int length = 0;
        byte[] buffer = new byte[1024];
        while (-1 != (length = is.read(buffer))) {
            bos.write(buffer, 0, length);
        }
        is.close();
        bos.close();

        return bos.toByteArray();
    }

    @Override
    public int getContentLength() {
        return httpConn.getContentLength();
    }

    @Override
    public void close() {
        if (httpConn != null) {
            httpConn = null;
        }
    }
}