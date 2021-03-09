package multi.test;

import multi.common.ThreadService;
import multi.instance.BaseInstance;

import java.util.ArrayList;
import java.util.List;

public class IssueTest {

    /**
     * 不加锁的多线程出现代码原子性不一致问题实例
     *
     * @param args
     */
    public static void main(String[] args) {

        BaseInstance issueInstance = new BaseInstance();

        System.out.println("100个线程自增10000次,理论结果：        1000000");
        System.out.println("初始值：" + issueInstance.getResult());

        // 初始化线程组
        List<Thread> threads = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            Thread incrementThread = new Thread(() -> issueInstance.increment());
            threads.add(incrementThread);
        }

        // 启动线程池里线程并等待所有线程运行结束
        ThreadService.threadPoolRun(threads);

        System.out.println("未做任何限制的自增逻辑并发时实际结果： " + issueInstance.getResult());
    }

    private static final int COUNT = 100;
}
