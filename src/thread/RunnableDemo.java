package thread;


/**
 * @author lanwei
 * @email 335747949@qq.com
 */
public class RunnableDemo {
    public static void main(String[] args) {
//        //创建Runable对象，表示线程要执行的功能
//        MyRunnale myRunnale = new MyRunnale();
//        //创建线程对象
//        Thread thread = new Thread(myRunnale,"子线程");
//        //开始执行
//        thread.start();
//
//        for (int i=0;i<30;i++) {
//            System.out.println("main........."+i);
//        }

        /**
         * 使用匿名内部类的方式创建线程
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<50;i++) {
                    System.out.println(Thread.currentThread().getName()+"............."+i);
                }
            }
        };

        Thread thread = new Thread(runnable,"子线程");
        thread.start();

        for (int i=0;i<30;i++) {
            System.out.println("main............."+i);
        }
    }
}

class MyRunnale implements java.lang.Runnable{

    @Override
    public void run() {
        for(int i=0;i<50;i++) {
            System.out.println(Thread.currentThread().getName()+"............."+i);
        }
    }
}