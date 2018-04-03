package heap;

/**
 * 链接管理类
 */
public interface ConnectionManager {
    /**
     * 给定一个url , 打开一个连接
     */
    Connection open(String url) throws ConnectionException;
}