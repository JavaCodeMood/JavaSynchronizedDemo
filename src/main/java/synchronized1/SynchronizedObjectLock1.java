package synchronized1;

/**
 * @ClassName: SynchronizedObjectLock1
 * @Description: synchronized对象锁，代码块实现
 * @Author: liuhefei
 * @Date: 2019/3/2
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedObjectLock1 implements Runnable {
    static SynchronizedObjectLock1 instance = new SynchronizedObjectLock1();
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void run() {

        //代码块1
        synchronized (lock1){
            System.out.println("对象锁代码块1：" + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);  //休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock1 结束运行");

        }

        //代码块2
        synchronized (lock2){
            System.out.println("对象锁代码块2：" + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);  //休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock2 结束运行");
        }

    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        //调用thread.isAlive()可以知道线程是否在运行，所以while死循环也可以做到”等待线程执行完，再执行下一行的代码的效果“
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("执行完成");
    }
}
