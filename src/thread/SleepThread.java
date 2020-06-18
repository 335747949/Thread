package thread;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class SleepThread extends Thread{

    @Override
    public void run() {
        for(int i=0;i<50;i++) {
            System.out.println(Thread.currentThread().getName()+".........."+i);
//            try {
//                //线程放弃
//                Thread.sleep(300);
//                //线程放弃
//                //Thread.yield();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}

class SleepThreadTest{
    public static void main(String[] args) {

        SleepThread s1 = new SleepThread();
        s1.setName("s1");
        SleepThread s2 = new SleepThread();
        s2.setName("s2");
        SleepThread s3 = new SleepThread();
        s3.setName("s3");

        //设置线程优先级   10最高
        s1.setPriority(1);
        s3.setPriority(10);

        s1.start();
//        try {
//            //线程加入，并阻塞当前线程，直到加入线程执行完
//            s1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        s2.start();
        s3.start();

        for(int i=0;i<50;i++) {
            System.out.println("main.............."+i);
        }
    }
}
