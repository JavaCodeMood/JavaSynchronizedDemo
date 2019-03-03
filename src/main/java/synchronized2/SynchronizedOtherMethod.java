package synchronized2;

/**
 * @ClassName: SynchronizedOtherMethod
 * @Description: 可重入锁的粒度：验证可重入不要求是同一个方法
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedOtherMethod {
    public synchronized void method1(){
        System.out.println("我是method1");
        method2();
    }

    public synchronized void method2(){
        System.out.println("我是method2");
    }

    public static void main(String[] args) {
        SynchronizedOtherMethod som = new SynchronizedOtherMethod();
        som.method1();
    }
}
