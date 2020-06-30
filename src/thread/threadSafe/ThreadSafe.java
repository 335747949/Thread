package thread.threadSafe;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class ThreadSafe {
    public static void main(String[] args) {

        //ArrayList<String> list = new ArrayList<>();

        //jdk1.5之前  使用Collections线程安全方法将集合转化为线程安全的集合
        //List<String> list1 = Collections.synchronizedList(list);

        //jdk1.5之后  并发包提供的线程安全的集合
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();

        //创建线程
        for(int i=0;i<20;i++){
            int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<10;j++){
                        list.add(Thread.currentThread().getName()+"="+temp+"="+j);
                        System.out.println(list);
                    }

                }
            }).start();
        }
    }

}
