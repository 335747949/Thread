package thread.threads;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class subMoney implements Runnable{
    private BankCard card;

    public subMoney(BankCard card) {
        this.card = card;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            card.take(1000);
        }
    }
}
