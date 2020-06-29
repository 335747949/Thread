package thread.lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock的使用
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Mylist {

    //创建锁
    private Lock lock = new ReentrantLock();
    private String[] str = {"A","B","","",""};
    private Integer count=2;

    public void add(String string){
        lock.lock();
        try {
            str[count] = string;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            lock.unlock();
        }
        count++;
        System.out.println(Thread.currentThread().getName()+"添加了"+string);
    }


    public String[] getStr() {
        return str;
    }
}
