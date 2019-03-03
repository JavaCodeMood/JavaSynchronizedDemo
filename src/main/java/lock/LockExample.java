package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LockExample
 * @Description: Lock方法
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class LockExample {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();  //加锁

        lock.unlock();  //释放锁

        lock.tryLock();  //尝试获取锁

        try {
            lock.tryLock(1000, TimeUnit.SECONDS);  //设置获取锁的超时时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
