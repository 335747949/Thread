package thread.bread;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class Product implements Runnable{

    private BreadCon con;

    public Product(BreadCon con) {
        this.con = con;
    }

    @Override
    public void run() {
        for(int i=0;i<=30;i++){
           con.input(new Bread(i,Thread.currentThread().getName()));
        }
    }
}
