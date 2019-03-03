package synchronized1;

import java.awt.*;

/**
 * @ClassName: SynchronizedObjectLock
 * @Description: 对象锁示列，代码块形式
 * 两个线程同时访问一个对象的同步方法：两个线程串行执行
 *
 * @Author: liuhefei
 * @Date: 2019/3/2
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedObjectLock implements Runnable{
    static SynchronizedObjectLock instance = new SynchronizedObjectLock();


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
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();  //启动
        t2.start();
        //调用thread.isAlive()可以知道线程是否在运行，所以while死循环也可以做到”等待线程执行完，再执行下一行的代码的效果“
        while(t1.isAlive() || t2.isAlive()){

        }
        System.out.println("finished");
    }
}
