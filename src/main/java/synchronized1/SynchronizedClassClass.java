package synchronized1;

/**
 * @ClassName: SynchronizedClassClass
 * @Description: 类锁的第二种形式——synchronized(*.class)代码块
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedClassClass implements Runnable{
    static SynchronizedClassClass instance1 = new SynchronizedClassClass();
    static SynchronizedClassClass instance2 = new SynchronizedClassClass();

    public void run() {
       method();
    }

    private void method(){
        synchronized (SynchronizedClassClass.class){
            System.out.println("我是类锁的第二种形式：synchronized(*.class).我叫：" + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "运行结束");
        }
    }
    public static void main(String[] args){
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }

        System.out.println("线程执行结束");
    }
}
