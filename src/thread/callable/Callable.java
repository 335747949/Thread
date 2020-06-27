package thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * callable接口
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //1 创建callable对象 （使用匿名内部类）
        java.util.concurrent.Callable<Integer> callable = new java.util.concurrent.Callable<Integer>() {
            int sum;
            @Override
            public Integer call() throws Exception {
                System.out.println("执行任务的线程是："+Thread.currentThread().getName()+".......");
                for(int i=0;i<=100;i++) {
                    sum+=i;
                }
                return sum;
            }
        };

        //2 将callable对象转化为一个可执行任务
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);

        //3 创建线程
        Thread thread = new Thread(futureTask);

        //4 启动线程
        thread.start();

        //5 获取结果
        Integer sum = futureTask.get();
        System.out.println("结果为："+sum);
    }
}
