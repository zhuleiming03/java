package multi;

public class Index {

    // https://blog.csdn.net/hanchao5272/article/details/79437370

    // 不加锁的多线程会出现代码原子性不一致问题
    // 实例 IssueTest

    // synchronized 关键字以同步方法和同步代码块的方式，为方法和代码块上的对象加锁。
    // synchronized 关键字能够保证代码的原子性、可见性和有序性。
    // 使得同一时刻，在这个对象上的多个线程，只能由持有这个对象锁的单个线程进行代码的调用执行。
    // 实例 SolveTest

    // 同步代码块比同步方法的锁住的范围更小，所以性能更好。但实现更复杂
    // 实例 FieldTest

    // 对象锁：只有使用同一对象的线程才会受锁的影响，多个对象调用同一方法也不会受影响。
    // 类锁：类锁是所有线程共享的锁，所以同一时刻，只能有一个线程使用加了锁的方法或方法体，不管是不是同一个实例。
    // 实例 LockTypeTest

    //    大类	      小类（锁定对象）	    锁定范围	        锁          可同步对象	不同步对象
    // 同步代码块	加锁对象是本地变量	    方法块{}内的代码   对象锁       单个对象	多个对象
    // 同步代码块	加锁对象是类静态变量	方法块{}内的代码   类锁	        多个对象	-
    // 同步代码块	加锁对象是共享变量	    方法块{}内的代码   对象锁	    多个对象	-
    // 同步代码块	加锁对象是类对象	    方法块{}内的代码   类锁	        多个对象	-
    //  同步方法	修饰的是普通方法	    整个方法	       对象锁       单个对象	多个对象
    //	同步方法	修饰的是静态方法	    整个方法	       类锁         多个对象	-

}