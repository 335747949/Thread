package thread;



/**
 * 四个窗口给卖30张票
 * @author lanwei
 * @email 335747949@qq.com
 */
public class TickeWin {
    public static void main(String[] args) {
        TickeWinow tickeWinow01 = new TickeWinow("一号窗口");
        tickeWinow01.start();
        TickeWinow tickeWinow02 = new TickeWinow("二号窗口");
        tickeWinow02.start();
        TickeWinow tickeWinow03 = new TickeWinow("三号窗口");
        tickeWinow03.start();
        TickeWinow tickeWinow04 = new TickeWinow("四号窗口");
        tickeWinow04.start();

    }
}
class TickeWinow extends Thread{
    public TickeWinow() {
    }
    public TickeWinow(String name) {
        super(name);
    }
    @Override
    public void run() {
        int ticke = 30;
        while(true) {
                if(ticke <= 0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"卖了第"+ticke+"张票");
                ticke--;
        }
    }
}