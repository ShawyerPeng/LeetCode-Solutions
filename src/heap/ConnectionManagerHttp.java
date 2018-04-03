package heap;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 链接管理类
 */
public class ConnectionManagerHttp implements ConnectionManager {
    @Override
    public Connection open(String url) throws ConnectionException {
        try {
            URL u = new URL(url);
            HttpURLConnection httpConn = (HttpURLConnection) u.openConnection();
            Connection conn = new ConnectionHttp(httpConn);
            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}