package thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class TestTicke {
    public static void main(String[] args) {
        Ticke ticke = new Ticke();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for(int i=0;i<4;i++){
            executorService.submit(ticke);
        }

        executorService.shutdown();
    }
}
