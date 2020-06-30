package thread.threadSafe;

import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class CopyOnWriterArrayList {
    public static void main(String[] args) {
        //1 创建集合
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        //2 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //3 创建任务
        for(int i=0;i<5;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10;j++) {
                        list.add(Thread.currentThread().getName()+(new Random().nextInt(1000)));
                        System.out.println(list.get(j));
                    }
                }
            });
        }
        //4 关闭线程池
        executorService.shutdown();

        //5 打印结果
        while(!executorService.isTerminated()) {

        }
        System.out.println("元素个数为："+list.size());
    }

}
