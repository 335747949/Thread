package thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.1 创建固定个数线程池
        //ExecutorService executorService = Executors.newFixedThreadPool(4);
        //1.2 创建线程缓冲池，线程个数由任务个数决定
        ExecutorService executorService = Executors.newCachedThreadPool();
        //1.3 创建一个单线程线程池
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //1.4 创建一个调度线程池
        //ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);

        //2 创建任务（使用匿名内部类）
        Runnable runnable = new Runnable() {
            private Integer ticke = 100;
            @Override
            public void run() {
                while(true) {
                    if(ticke<=0){
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+"卖了第"+ticke+"张票...");
                    ticke--;
                }
            }

        };
        //3 提交任务
        for(int i=0;i<6;i++) {
            executorService.submit(runnable);
        }
        //4 关闭线程池
        executorService.shutdown();
    }
}
