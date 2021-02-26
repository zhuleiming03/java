package multi.test.solve;

import multi.common.ThreadService;
import multi.instance.atomicity.AtomicityAtomicInstance;
import multi.instance.atomicity.AtomicityLockInstance;
import multi.instance.atomicity.AtomicitySynchronizedInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * 并发原子性测试
 * 原子性：一个或多个操作，要么全部执行且在执行过程中不被任何因素打断，要么全部不执行。
 * 不采取任何的原子性保障措施的自增操作会由于多线程同时自增而导致实际结果未达到预期效果
 */
public class AtomicitySolveTest {

    /**
     * synchronized 关键字
     * Lock 接口
     * Atomic 变量
     *
     * @param args
     */
    public static void main(String[] args) {

        // 通过 synchronized 保证代码块的原子性
        AtomicitySynchronizedInstance synchronizedInstance = new AtomicitySynchronizedInstance();

        // 通过 Lock 接口保证指定范围代码的原子性
        AtomicityLockInstance lockInstance = new AtomicityLockInstance();

        // 通过 Atomic 类型保证类型的原子性
        AtomicityAtomicInstance atomicInstance = new AtomicityAtomicInstance();

        System.out.println("100个线程自增10000次,理论结果：        1000000");
        System.out.printf("初始值：%s ,%s ,%s \n", synchronizedInstance.getCount(),
                lockInstance.getCount(), atomicInstance.getCount());

        // 初始化线程组
        List<Thread> threads = new ArrayList<>(3 * COUNT);
        for (int i = 0; i < COUNT; i++) {
            Thread synchronizedIncrementThread = new Thread(() -> synchronizedInstance.increment());
            Thread atomicIncrementThread = new Thread(() -> atomicInstance.increment());
            Thread lockIncrementIncrementThread = new Thread(() -> lockInstance.increment());
            threads.add(synchronizedIncrementThread);
            threads.add(atomicIncrementThread);
            threads.add(lockIncrementIncrementThread);
        }

        // 启动线程池里线程并等待所有线程运行结束
        ThreadService.threadPoolRun(threads);

        System.out.println("通过 synchronized 保证代码块的原子性： " + synchronizedInstance.getCount());
        System.out.println("通过 Lock 接口保证指定范围代码的原子性:" + lockInstance.getCount());
        System.out.println("通过 Atomic 类型保证类型的原子性：     " + atomicInstance.getCount());
    }

    private static final int COUNT = 100;
}
