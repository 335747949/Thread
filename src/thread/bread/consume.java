package thread.bread;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class consume implements Runnable{

    private BreadCon con;

    public consume(BreadCon con) {
        this.con = con;
    }

    @Override
    public void run() {
        for(int i=0;i<=30;i++){
            con.output();
        }
    }
}
