package test.executorService;

import thread.InstanceThread;
import java.util.concurrent.*;

/**
 * 创建一个可缓存线程池
 */
public class CachedThreadPoolTest {

    public static void main(String[] args) {

        // pool 等价于 cachedThreadPool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS, new SynchronousQueue<>());

        // 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次新建线程
        for (int i = 0; i < COUNT; i++) {
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pool.execute(new InstanceThread());
        }

        // 执行剩余线程 不接受新的线程
        pool.shutdown();
    }

    private static final Integer COUNT = 5;
}
