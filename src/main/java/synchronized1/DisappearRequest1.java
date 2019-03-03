package synchronized1;

/**
 * @ClassName: DisappearRequest1
 * @Description: 消失的请求数
 * @Author: liuhefei
 * @Date: 2019/3/2
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance = new DisappearRequest1();

    static int i = 0;

    //@Override
    public void run(){
        for(int j = 0; j < 100000; j++){
            i++;
        }
    }

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
