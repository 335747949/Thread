package thread;

/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class ThreadDemo01 {

    /**
     * 创建线程的方式：
     * 1.继承Thread类
     * 2.实现Runnable接口
     * 3.使用匿名内部类
     * 4.实现callable接口
     * 5.使用线程池的方式
     */

    public static void main(String[] args) {
        thread thread = new thread("子线程000001");
        //thread.setName("子线程001");
        thread.start();

        thread t2 = new thread("子线程0000002");
        //t2.setName("子线程002");
        t2.start();

        for(int i=0;i<30;i++){
            System.out.println("主线程============="+i);
        }
    }

}
class thread extends Thread{

    public thread() {
    }
    public thread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0;i<40;i++){
            //System.out.println("线程id："+getId()+",线程名称："+getName()+"........"+i);
            System.out.println(Thread.currentThread().getId()+" 线程名称:"+Thread.currentThread().getName()+"............"+i);
        }
    }
}