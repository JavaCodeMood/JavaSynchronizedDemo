package synchronized2;

/**
 * @ClassName: SynchronizedRecursion
 * @Description: 可重入锁的粒度：递归调用本方法,验证同一个方法是可重入的
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedRecursion {
    int a = 0;

    public static void main(String[] args) {
        SynchronizedRecursion sr = new SynchronizedRecursion();
        sr.method1();
    }

    private synchronized void method1(){
        System.out.println("synchronized修饰的方法，a = " + a);
        if(a==0){
            a++;
            method1();
        }
    }
}
