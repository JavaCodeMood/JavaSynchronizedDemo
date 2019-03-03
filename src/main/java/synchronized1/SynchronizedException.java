package synchronized1;

/**
 * @ClassName: SynchronizedException
 * @Description: 方法抛异常，会释放锁;
 * 展示不抛异常前和抛出异常后的对比，一旦抛出了异常，第二个线程会立刻进入同步方法，意味着锁已经释放
 * synchronized抛出异常之后，JVM会主动释放锁，与Lock不同
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedException implements Runnable{

    static SynchronizedStaticAndNormal instance = new SynchronizedStaticAndNormal();

    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method1();
        }else {
            method2();
        }
    }

    public synchronized void method1(){
        System.out.println("加锁synchronized方法，方法名：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
            //throw new Exception();   //抛异常
        } catch (Exception e){
            e.printStackTrace();
        }
        throw new RuntimeException();
        //System.out.println("同步方法" + Thread.currentThread().getName() + " method1 执行结束");
    }

    public synchronized void method2(){
        System.out.println("加锁synchronized方法，方法名：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步方法" + Thread.currentThread().getName() + " method2 执行结束");
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
