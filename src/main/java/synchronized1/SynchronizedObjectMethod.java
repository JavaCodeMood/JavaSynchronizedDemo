package synchronized1;

/**
 * @ClassName: SynchronizedObjectMethod
 * @Description:  对象锁实例——方法锁形式
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedObjectMethod implements Runnable{
    static SynchronizedObjectMethod instance = new SynchronizedObjectMethod();

    public void run() {
        method();
    }

    public synchronized void method(){
        System.out.println("对象锁方法修饰形式，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束运行");
    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("执行完成");
    }
}
