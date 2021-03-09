package multi.test;

import multi.common.ThreadService;
import multi.instance.BaseInstance;
import multi.instance.ClassLockInstance;
import multi.instance.ObjectLockInstance;

import java.util.ArrayList;
import java.util.List;

public class LockTypeTest {

    /**
     * 锁类型（对象锁、类锁）
     * 对象锁：只有使用同一对象的线程才会受锁的影响，多个对象调用同一方法也不会受影响。
     * 类锁：类锁是所有线程共享的锁，所以同一时刻，只能有一个线程使用加了锁的方法或方法体，不管是不是同一个实例。
     * 被锁的对象要保证被多个线程共同使用
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("多个对象实例采用对象锁不能达到同步目的");
        objectLockTest();

        System.out.println("\n对象锁和类锁并用不能达到同步目的");
        mixLockTest();

        System.out.println("\n多个对象实例采用类锁能达到同步目的");
        classLockTest();
    }

    private static final int COUNT = 100;

    public static int result = 0;

    private static void mixLockTest() {
        ClassLockInstance one = new ClassLockInstance();
        ObjectLockInstance two = new ObjectLockInstance();
        incrementLogic(one, two);
    }

    private static void objectLockTest() {
        ObjectLockInstance one = new ObjectLockInstance();
        ObjectLockInstance two = new ObjectLockInstance();
        incrementLogic(one, two);
    }

    private static void classLockTest() {
        ClassLockInstance one = new ClassLockInstance();
        ClassLockInstance two = new ClassLockInstance();
        incrementLogic(one, two);
    }

    private static void incrementLogic(BaseInstance one, BaseInstance two) {

        result = 0;
        System.out.println("100个线程自增10000次,理论结果：1000000");
        System.out.println("初始值：" + result);

        // 初始化线程组
        List<Thread> threads = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            if (i % 2 == 1) {
                Thread incrementThread = new Thread(() -> one.increment());
                threads.add(incrementThread);
            } else {
                Thread incrementThread = new Thread(() -> two.increment());
                threads.add(incrementThread);
            }
        }

        // 启动线程池里线程并等待所有线程运行结束
        ThreadService.threadPoolRun(threads);

        System.out.println("实际结果：" + result);
    }
}
