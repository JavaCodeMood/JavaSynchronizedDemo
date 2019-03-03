package synchronized2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SynchronizedToLock
 * @Description: 获取和释放锁
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedToLock {

    Lock lock = new ReentrantLock();

    public synchronized void method1(){
        System.out.println("我是synchronized锁");
    }

    public void method2(){
        lock.lock();  //加锁
        try{
            System.out.println("我是lock锁");
        }finally {
            lock.unlock();  //释放锁
        }
    }

    public static void main(String[] args) {
        SynchronizedToLock stl = new SynchronizedToLock();
        stl.method1();
        stl.method2();
    }
}
