package thread.bread;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class TestBreadCon {
    public static void main(String[] args) {
        BreadCon breadCon = new BreadCon();

        Product product = new Product(breadCon);
        consume consume = new consume(breadCon);

        Thread thread01 = new Thread(product,"生产者");
        Thread thread02 = new Thread(consume, "消费者");
        Thread thread03 = new Thread(product, "周杰伦");
        Thread thread04 = new Thread(consume, "昆凌");

        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();

    }
}
