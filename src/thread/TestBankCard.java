package thread;

/**
 * 存取钱，共同操作资源（使用匿名内部类的方式）
 * @author lanwei
 * @email 335747949@qq.com
 */
public class TestBankCard {
    public static void main(String[] args) {
        BankCard bankCard = new BankCard();

        Runnable add = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    synchronized (bankCard){
                        bankCard.setCard(bankCard.getCard()+1000);
                        System.out.println(Thread.currentThread().getName()+"存了1000块，余额为："+bankCard.getCard());
                    }
                }
            }
        };

        Runnable sub = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    synchronized (bankCard){
                        if(bankCard.getCard()>=1000){
                            bankCard.setCard(bankCard.getCard()-1000);
                            System.out.println(Thread.currentThread().getName()+"取了1000块，余额为："+bankCard.getCard());
                        }else {
                            System.out.println("余额不足，请赶快存钱！");
                            i--;
                        }
                    }
                }
            }
        };

        new Thread(add,"周杰伦").start();
        new Thread(sub,"昆凌").start();
    }
}
