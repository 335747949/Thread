package thread.threadSafe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class ConcureetHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String ,String > hashMap = new ConcurrentHashMap<>();

        for(int i=0;i<5;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int k=0;k<10;k++){
                        hashMap.put(Thread.currentThread().getName(),k+"");
                        System.out.println(hashMap);
                    }
                }
            }).start();
        }
    }
}
