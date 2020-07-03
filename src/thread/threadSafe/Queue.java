package thread.threadSafe;

import java.util.LinkedList;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Queue {
    public static void main(String[] args) {

        java.util.Queue<String> queue = new LinkedList<>();

        //入队
        queue.offer("苹果");
        queue.offer("香蕉");
        queue.offer("西瓜");
        queue.offer("哈密瓜");
        queue.offer("芒果");
        queue.offer("荔枝");

        System.out.println("获取队列第一个元素："+queue.peek());
        System.out.println("================================");
        System.out.println("元素个数："+queue.size());

        //出队
        for(int i=0;i<6;i++) {
            System.out.println(queue.poll());
        }

        System.out.println("出队完成："+queue.size());
    }
}
