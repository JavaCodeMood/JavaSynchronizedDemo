package synchronized2;

/**
 * @ClassName: Decompilation
 * @Description: 反编译字节码
 * @Author: liuhefei
 * @Date: 2019/3/3
 * @blog: https://www.imooc.com/u/1323320/articles
 **/
public class Decompilation {

    private Object object = new Object();

    //同步代码块
    public void insert(Thread thread){
        synchronized (object){

        }
    }
}
