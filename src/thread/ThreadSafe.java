package thread;

import java.util.Arrays;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class ThreadSafe extends Thread{
    private static int index = 0;
    public static void main(String[] args) {

        String[] s = new String[5];

        Runnable runnable01 = new Runnable() {
            @Override
            public void run() {
                //同步代码块
                synchronized (s){
                    s[index] = "hello";
                    index++;
                }
            }
        };

        Runnable runnable02 = new Runnable() {
            @Override
            public void run() {
                synchronized (s){
                    s[index] = "world";
                    index++;
                }
            }
        };

        Thread a = new Thread(runnable01,"a线程");
        Thread b = new Thread(runnable02,"a线程");

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(s));
    }
}
