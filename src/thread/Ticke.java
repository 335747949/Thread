package thread;

/**
 * 共享资源（共卖100张票）
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Ticke implements Runnable{

    private int ticke = 100;

    @Override
    public void run() {
        while(true) {
            if(ticke<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"卖了"+ticke+"张票");
            ticke--;
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