package synchronized1;

/**
 * @ClassName: SynchronizedClassStatic
 * @Description: 类锁的第一种形式——static形式
 * 两个线程访问的是synchronized的静态方法：两个锁对象是同一个锁，串行执行
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedClassStatic implements Runnable{
    static SynchronizedClassStatic instance1 = new SynchronizedClassStatic();
    static SynchronizedClassStatic instance2 = new SynchronizedClassStatic();

    public void run() {
        method();
    }

    //静态方法体
    public static synchronized  void method(){
        System.out.println("我是类锁的静态static形式,我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
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
