package thread;

import sun.rmi.runtime.NewThreadAction;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Tickes extends Thread{

    private int ticke = 100;
    @Override
    public void run() {
        while (true){
            if(!sale()){
                break;
            }
        }
    }

    public synchronized boolean sale(){
        if(ticke <= 0){
            return false;
        }
        System.out.println(Thread.currentThread().getName()+"卖了"+ticke+"张票");
        ticke--;
        return true;
    }
}
class TicksDemo{
    public static void main(String[] args) {

        Tickes tickes = new Tickes();

        Thread thread01 = new Thread(tickes,"01...");
        Thread thread02 = new Thread(tickes,"02......");
        Thread thread03 = new Thread(tickes,"03");
        Thread thread04 = new Thread(tickes,"04..");

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
    }
}