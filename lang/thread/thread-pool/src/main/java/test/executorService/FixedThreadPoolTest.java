package test.executorService;

import thread.InstanceThread;
import java.util.concurrent.*;

/**
 * 创建一个可重用固定个数的线程池
 */
public class FixedThreadPoolTest {

    public static void main(String[] args){

        // pool 等价于 fixedThreadPool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService pool = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        // 因为线程池大小为2，两个线程轮流执行任务
        for (int i = 0; i < COUNT; i++) {
            pool.execute(new InstanceThread());
        }

        // 执行剩余线程 不接受新的线程
        pool.shutdown();

    }

    private static final Integer COUNT = 5;
}
