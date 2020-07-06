package thread.threadSafe;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class BlockingQueueDemo01 {
    public static void main(String[] args) {

        //阻塞队列
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(6);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<30;i++) {
                    try {
                        queue.put(i);
                        System.out.println(Thread.currentThread().getName()+"买了"+i+"个面包");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"周杰伦");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<30;i++) {
                    try {
                        Integer num = queue.take();
                        System.out.println(Thread.currentThread().getName()+"吃了"+num+"个面包");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"昆凌");

        t1.start();
        t2.start();
    }
}
