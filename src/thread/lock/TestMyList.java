package thread.lock;

import java.util.Arrays;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class TestMyList {
    public static void main(String[] args) throws InterruptedException {
        Mylist list = new Mylist();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                list.add("你好");
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                list.add("Jay");
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable1);

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(Arrays.toString(list.getStr()));

    }
}
