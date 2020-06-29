package thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class ReadWriteLock {
    //创建读写锁
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    //获得读锁
    private ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
    //获得写锁
    private ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();
    private String value;

    //读操作  不互斥不阻塞
    public String getValue() {
        readLock.lock();
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("读取" + value);
            return value;
        } finally {
            readLock.unlock();
        }
    }

    //写操作  互斥阻塞
    public void setValue(String value) {
        writeLock.lock();
        try {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("写入" + value);
            this.value = value;
        } finally {
            writeLock.unlock();
        }
    }

}
