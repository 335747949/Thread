package thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Ticke implements Runnable{
    private Integer ticke = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true) {
            lock.lock();
            try {
                if(ticke<=0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"卖了第"+ticke+"张票");
                ticke--;
            }finally {
                lock.unlock();
            }
        }

    }
}
