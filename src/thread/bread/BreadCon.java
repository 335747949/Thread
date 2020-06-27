package thread.bread;


/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class BreadCon {

    private Bread[] cons = new Bread[6];

    private Integer index=0;

    //生产者
    public synchronized void input(Bread bread){

        while(index>=6){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cons[index] = bread;

        System.out.println(Thread.currentThread().getName()+"生产了"+bread.getId()+"号面包.......");

        index++;
        this.notifyAll();

    }

    //消费者
    public synchronized void output(){
        while(index<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index--;
        Bread bread = cons[index];

        System.out.println(Thread.currentThread().getName()+"消费了"+bread.getId()+"号面包");

        cons[index] = null;
        this.notifyAll();

    }



}
