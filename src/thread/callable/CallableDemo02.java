package thread.callable;


import java.util.concurrent.*;
import java.util.concurrent.Callable;

/**
 * callable接口结合线程池使用
 * @author lanwei
 * @email 335747949@qq.com
 */
public class CallableDemo02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       
        //1 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        
        //2 提交任务 Future:将要执行完任务的结果
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            int sum;

            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "开始计算结果....");
                for (int i = 0; i <= 100; i++) {
                    sum += i;
                    Thread.sleep(50);
                }
                return sum;
            }
        });
        //3 获取任务结果
        System.out.println("结果为："+future.get());

        //4 关闭线程池
        executorService.shutdown();
    }
}
