package synchronized2;

/**
 * @ClassName: SynchronizedSuperClass
 * @Description: 可重入粒度测试,调用父类的方法，验证可重入不要求是同一个类中
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class SynchronizedSuperClass {

    public synchronized void doSomething(){
        System.out.println("我是父类方法");
    }
}

class TestClass extends SynchronizedSuperClass{
    public synchronized void doSomething(){
        System.out.println("我是子类方法");
        super.doSomething();
    }

    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.doSomething();
    }
}
