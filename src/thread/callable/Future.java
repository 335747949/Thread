package thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //1 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //2 创建任务
        java.util.concurrent.Future<Integer> future01 = executorService.submit(new Callable<Integer>() {
            int sum = 0;

            @Override
            public Integer call() throws Exception {
                for (int i = 0; i <= 50; i++) {
                    sum += i;
                }
                System.out.println(Thread.currentThread().getName()+"计算1-50的和...");
                return sum;
            }
        });
        java.util.concurrent.Future<Integer> future02 = executorService.submit(new Callable<Integer>() {
            int sum = 0;
            @Override
            public Integer call() throws Exception {
                for(int i=51;i<=100;i++) {
                    sum+=i;
                }
                System.out.println(Thread.currentThread().getName()+"计算51-100的和...");
                return sum;
            }
        });

        //3 获取任务结果
        int sum = future01.get() + future02.get();
        System.out.println("计算结果为："+sum);

        //4 关闭线程池
        executorService.shutdown();
    }
}
