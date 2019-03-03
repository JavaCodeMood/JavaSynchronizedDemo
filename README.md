##synchronized: 
JVM会自动通过使用monitor来加锁和解锁，保证了同时只有一个线程可以执行指定代码，从而保证了线程安全，
同时具有可重入和不可中断的性质。        
1.修饰方法和对象后保证同一时刻只能有一个线程能访问到   
2.具有可重入和不可中断性    
3.无法知道是否已经获取到锁，无法设置等待超时，只有持有的线程释放或者出现异常自动释放。不够灵活无法选择性释放锁    


###可重入：    
一个线程拿到了锁，这个线程可以再次使用该锁对其他方法，说明该锁是可以重入的    
###不可重入：    
一个线程拿到锁了，如果需要再次使用该锁，必须先释放该锁才能再次获取    
synchronized是可重入锁  
###可重入锁的好处：     
1 避免死锁 2 提升封装性   
粒度：     
可重入的特性是线程级别的，不是调用级别的

##加锁和释放锁的原理：   
每个类的实例对应一把锁，而每个synchronized方法都必须首先获得调用该方法类的实例的锁，才能执行；
否则这个线程会阻塞。而这个方法一旦执行了，它就会独占这把锁，直到该方法返回或者抛出异常，才会释放锁。
释放锁之后，其他线程才能再次获得这把锁，进入可执行状态。   
当一个对象中有synchronized修饰的方法或者代码块的时候，要想执行这段代码就必须先获得这个对象锁。如果
这个对象的锁已经被其他调用者所占用就必须等待该对象是否这个锁。    
所有的java对象都含有一个互斥锁，这个锁由JVM自动获取或释放，我们只要指定这个对象就可以了，不需要关注
这个锁的获取与释放。    

###获取和释放锁的时机：内置锁    
每个Java对象都可以用作一个实现同步的锁，这个锁叫内置锁或者叫监视器锁。  
线程在进入同步代码块之前，会自动获得这个锁，并且在退出的时候，会自动释放这个锁。    
获得这个内置锁的唯一途径就是进入这个锁所保护的同步代码或者方法中。    


###查看JVM字节码：    
1、将Java文件编程为 .class文件：javac xxx.java

2、通过反编译查看字节码，javap -verbose xxx.class

3、synchronized如何实现的，有个加锁monitorenter和解锁monitorexit

读到该指令，会让monitor计数器+1或-1

###可重入原理   
1、JVM负责跟踪对象被加锁的次数；    
2、有个monitor计数器，线程第一次给对象加锁的时候，计数变为1.每当这个相同的线程在此对象上再次获得锁时，计数会递增。    
3、任务结束离开，则会执行monitorexit，计数递减，直到完全释放     

###synchronized缺陷    
1、效率低，锁的释放情况少，一种是正常执行任务完释放，一种是异常JVM释放；    
试图获得锁时不能设定超时，不能中断一个试图获得锁的线程   
2、不够灵活，读的话可能不需要加锁，例如读写锁就比较灵活；   
加锁和释放的时机单一，每个锁仅有单一的条件（某个对象），可能是不够的    
3、无法判断状态，是否获取到锁    
​
###synchronized使用的注意点：   

1、锁的信息是保存在对象头中的、作用域不易过大，影响性能、避免死锁

2、如何选择Lock和synchronized关键字

1）建议都不使用，可以使用java.util.concurrent包中的Automic类、countDown等类

2）优先使用现成工具，如果没有就优先使用synchronized关键字，好处是写劲量少的代码就能实现功能。如果需要灵活的加解锁机制，则使用Lock接口

​


