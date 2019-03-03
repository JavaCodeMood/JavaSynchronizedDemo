package synchronized1;

/**
 * @ClassName: SynchronizedObjectLock
 * @Description: 对象锁示列，代码块形式
 * 两个线程访问的是两个对象的同步方法：两个锁对象互不干扰，并行执行
 * @Author: liuhefei
 * @Date: 2019/3/2
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedObjectLock2 implements Runnable{
    static SynchronizedObjectLock2 instance1 = new SynchronizedObjectLock2();
    static SynchronizedObjectLock2 instance2 = new SynchronizedObjectLock2();


    public void run() {
        synchronized (this){   //加锁保证串行执行
            System.out.println("对象锁代码块：" + Thread.currentThread().getName());

            try {
                Thread.sleep(3000);  //休眠3秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束运行");
        }
    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();  //启动
        t2.start();
        //调用thread.isAlive()可以知道线程是否在运行，所以while死循环也可以做到”等待线程执行完，再执行下一行的代码的效果“
        while(t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}
