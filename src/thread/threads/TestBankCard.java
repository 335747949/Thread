package thread.threads;


/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class TestBankCard {
    public static void main(String[] args) {
        BankCard bankCard = new BankCard();

        addMoney addMoney = new addMoney(bankCard);
        subMoney subMoney = new subMoney(bankCard);

        Thread thread01 = new Thread(addMoney,"001");
        Thread thread02 = new Thread(subMoney,"002");

        thread01.start();
        thread02.start();

    }
}
