package multi.test;


import multi.common.ThreadService;
import multi.instance.solve.*;

import java.util.ArrayList;
import java.util.List;

public class SolveTest {

    /**
     * synchronized 的五种实现方式
     * 加锁对象可以分为变量、对象实例、类
     * 加锁方式可以分为同步代码块和同步方法
     * 加锁性质分为类所和对象锁
     *
     * @param args
     */
    public static void main(String[] args) {

        SolveOneInstance oneInstance = new SolveOneInstance();
        SolveTwoInstance twoInstance = new SolveTwoInstance();
        SolveThreeInstance threeInstance = new SolveThreeInstance();
        SolveFourInstance fourInstance = new SolveFourInstance();

        System.out.println("100个线程自增10000次,理论结果：    1000000");

        // 初始化线程组
        List<Thread> threads = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            threads.add(new Thread(() -> oneInstance.increment()));
            threads.add(new Thread(() -> twoInstance.increment()));
            threads.add(new Thread(() -> threeInstance.increment()));
            threads.add(new Thread(() -> fourInstance.increment()));
            threads.add(new Thread(() -> SolveFiveInstance.increment()));
        }

        // 启动线程池里线程并等待所有线程运行结束
        ThreadService.threadPoolRun(threads);

        System.out.println("本地变量的自增逻辑并发时实际结果： " + oneInstance.getResult());
        System.out.println("静态变量的自增逻辑并发时实际结果： " + twoInstance.getResult());
        System.out.println("全局变量的自增逻辑并发时实际结果： " + threeInstance.getResult());
        System.out.println("实例    的自增逻辑并发时实际结果： " + fourInstance.getResult());
        System.out.println("类      的自增逻辑并发时实际结果： " + SolveFiveInstance.getResult());
    }

    private static final int COUNT = 100;

    public final static byte[] GLOBAL_OBJECT = new byte[0];
}
