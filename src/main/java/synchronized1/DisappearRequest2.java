package synchronized1;

/**
 * @ClassName: DisappearRequest1
 * @Description: 消失的请求数
 * @Author: liuhefei
 * @Date: 2019/3/2
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class DisappearRequest2 implements Runnable{
    static DisappearRequest2 instance = new DisappearRequest2();

    static int i = 0;

    //方法1：直接把synchronized加到方法上
   /* public synchronized void run(){
        for(int j = 0; j < 100000; j++){
            i++;
        }
    }*/

    //方法2：对象锁的同步代码块
    /*public synchronized void run(){
        synchronized (this){
            for(int j = 0; j < 100000; j++){
                i++;
            }
        }
    }*/

    //第三种：类锁：synchronized(*.class)
    public synchronized void run(){
        synchronized (DisappearRequest2.class){
            for(int j = 0; j < 100000; j++){
                i++;
            }
        }
    }

    //第四种：类锁
    /*public  void run(){
       method();
    }

    public static synchronized void method(){
        for(int j = 0; j < 100000; j++){
            i++;
        }
    }*/

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

        t1.join();  //等待线程结束
        t2.join();

        System.out.println("i=" + i);
    }
}
