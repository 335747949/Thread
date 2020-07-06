package thread.threadSafe;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class BlockingQueue {
    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

        queue.put("aaa");
        queue.put("bbb");
        queue.put("ccc");
        queue.put("ddd");
        queue.put("eee");
        queue.take();
        System.out.println("已经添加了5个与元素");
        queue.put("fff");
        System.out.println("添加了第6个元素");
        System.out.println(queue.toString());
    }
}
