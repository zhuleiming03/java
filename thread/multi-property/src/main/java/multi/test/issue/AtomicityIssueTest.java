package multi.test.issue;

import multi.common.ThreadService;
import multi.instance.atomicity.AtomicityIssueInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * 并发原子性测试
 * 原子性：一个或多个操作，要么全部执行且在执行过程中不被任何因素打断，要么全部不执行。
 * 不采取任何的原子性保障措施的自增操作会由于多线程同时自增而导致实际结果未达到预期效果
 */
public class AtomicityIssueTest {

    /**
     * 多线程并发对共享对象做自增操作，由于自增操作不符合原子性，导致自增实际结果小于预期值
     *
     * @param args
     */
    public static void main(String[] args) {

        AtomicityIssueInstance increment = new AtomicityIssueInstance();

        System.out.println("100个线程自增10000次,理论结果：        1000000");
        System.out.println("初始值：" + increment.getCount());

        // 初始化线程组
        List<Thread> threads = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            Thread incrementThread = new Thread(() -> increment.increment());
            threads.add(incrementThread);
        }

        // 启动线程池里线程并等待所有线程运行结束
        ThreadService.threadPoolRun(threads);

        System.out.println("未做任何限制的自增逻辑并发时实际结果： " + increment.getCount());
    }

    private static final int COUNT = 100;
}
