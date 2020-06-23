package thread.threads;



/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class BankCard {

    private double money;

    private boolean flag=false;   // true为有钱可以取钱   false为没钱可以存钱

    //存钱
    public synchronized void save(double m){
        if(flag){ //true  有钱可以取钱
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        money=money+m;
        System.out.println(Thread.currentThread().getName()+"存了1000，余额为"+money);
        flag=true;
        this.notify();

    }



    //取钱
    public synchronized void take(double m){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        money=money-m;
        System.out.println(Thread.currentThread().getName()+"取了1000，余额为"+money);
        flag=false;
        this.notify();
    }
}
