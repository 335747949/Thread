package thread;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * 共享资源（共卖100张票）
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Ticke implements Runnable{

    private int ticke = 100;
    Object object = new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (object){
                if(ticke<=0){
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"卖了"+ticke+"张票");
                ticke--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class demo01{
    public static void main(String[] args) {
        Ticke ticke = new Ticke();

        Thread thread01 = new Thread(ticke,"窗口1 ");
        Thread thread02 = new Thread(ticke,"窗口2  ");
        Thread thread03 = new Thread(ticke,"窗口3   ");
        Thread thread04 = new Thread(ticke,"窗口4    ");

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
    }
}