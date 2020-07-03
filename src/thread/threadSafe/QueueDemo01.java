package thread.threadSafe;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class QueueDemo01 {
    public static void main(String[] args) throws InterruptedException {

        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++) {
                    queue.offer(i);
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=6;i<10;i++) {
                    queue.offer(i);
                }
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("==========出队==========");

        int size = queue.size();

        for(int i=0;i<size;i++) {
            System.out.println(queue.poll());
        }


    }
}
