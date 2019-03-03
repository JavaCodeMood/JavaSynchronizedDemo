package synchronized1;

/**
 * @ClassName: SynchronizedStaticAndNormal
 * @Description: 同时访问静态synchronized和非静态synchronized方法: 同步执行
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedStaticAndNormal implements Runnable{
    static SynchronizedStaticAndNormal instance = new SynchronizedStaticAndNormal();

    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            medthStatic();
        }else {
            medthNoStatic();
        }
    }

    public synchronized static void medthStatic(){
        System.out.println("静态加锁synchronized方法，方法名：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("静态同步方法" + Thread.currentThread().getName() + " 执行结束");
    }

    public synchronized void medthNoStatic(){
        System.out.println("非静态加锁synchronized方法，方法名：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("非静态同步方法" + Thread.currentThread().getName() + " 执行结束");
    }

    public static void main(String[] args){
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()){

        }
        System.out.println("线程执行结束");
    }
}
