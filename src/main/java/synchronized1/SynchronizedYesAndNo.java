package synchronized1;

/**
 * @ClassName: SynchronizedYesAndNo
 * @Description: 同时访问同步方法和非同步方法： 同步执行
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedYesAndNo implements Runnable{
    static SynchronizedYesAndNo instance1 = new SynchronizedYesAndNo();
    static SynchronizedYesAndNo instance2 = new SynchronizedYesAndNo();

    public void run() {
       if(Thread.currentThread().getName().equals("Thread-0")){
           methodYes();
       }else {
           methodNo();
       }
    }

    //同步方法
    public synchronized void methodYes(){
        System.out.println("我是同步方法，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " + methodYes 执行结束");
    }

    //非同步方法
    public void methodNo(){
        System.out.println("我是非同步方法，我叫：" + Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " + methodNo 执行结束");
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
