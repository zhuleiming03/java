package test.executorService;

import thread.InstanceThread;
import java.util.concurrent.*;

/**
 * 创建一个单线程的线程池
 */
public class SingleThreadExecutorTest {

    public static void main(String[] args) {

        // pool 等价于 singleThreadExecutor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService pool = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        // 执行5个时长1秒的线程
        for (int i = 0; i < COUNT; i++) {
            pool.execute(new InstanceThread());
        }

        // 执行剩余线程 不接受新的线程
        pool.shutdown();
    }

    private static final Integer COUNT = 5;
}
