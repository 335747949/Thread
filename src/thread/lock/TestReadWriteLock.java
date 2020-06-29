package thread.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        Long startTime = System.currentTimeMillis();

        for(int i=0;i<2;i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    readWriteLock.setValue("张三"+(new Random().nextInt(100)));
                }
            });
        }

        for(int i=0;i<18;i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    readWriteLock.getValue();
                }
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()){
            //System.out.println("空转");
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("耗时"+(endTime-startTime));
    }
}
