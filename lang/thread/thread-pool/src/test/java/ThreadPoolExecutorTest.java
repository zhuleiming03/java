import common.Utils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.*;

/**
 * corePoolSize  线程池内至少含有线程数量
 * maximumPoolSize 线程池内最多含有线程数量
 * keepAliveTime 线程空闲多长时间后自动结束。
 * unit 线程空闲多长时间的单位
 * workQueue：LinkedBlockingQueue SynchronousQueue
 * * LinkedBlockingQueue（无界阻塞队列）
 * * * 队列最大值为Integer.MAX_VALUE。
 * * * 如果任务提交速度持续大余任务处理速度，会造成队列大量阻塞。
 * * * 因为队列很大，很有可能在拒绝策略前，内存溢出。是其劣势；
 * * SynchronousQueue（同步队列）
 * * * 这个队列类似于一个接力棒，入队出队必须同时传递，
 * * * 因为 CachedThreadPool 线程创建无限制，不会有队列等待，所以使用 SynchronousQueue；
 */
public class ThreadPoolExecutorTest {

    @Test
    public void newSingleThreadExecutorTest() {

        // 创建一个单线程的线程池
        // 等价于
        // ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService pool = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        multiThreadTest(pool);
    }

    @Test
    public void newFixedThreadPoolTest() {

        // 创建一个可重用固定个数的线程池
        // 等价于
        // ExecutorService pool = Executors.newFixedThreadPool(3);
        // 因为线程池大小为2，两个线程轮流执行任务
        ExecutorService pool = new ThreadPoolExecutor(2, 2, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

        multiThreadTest(pool);
    }

    @Test
    public void newCachedThreadPoolTest() {

        // 创建一个可缓存线程池
        // 等价于
        // ExecutorService pool = Executors.newCachedThreadPool();
        // 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次新建线程
        ExecutorService pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L,
                TimeUnit.SECONDS, new SynchronousQueue<>());

        multiThreadTest(pool);
    }

    public static void main(String[] args) {

        // 创建一个定长线程池，支持定时及周期性任务执行——延迟执行
        // 等价于
        //ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(3);

        System.out.println(LocalTime.now() + "----------- begin ------------");
        //延迟1秒后每3秒执行一次
        pool.scheduleAtFixedRate(() -> System.out.println(LocalTime.now() + " 延迟1秒后每3秒执行一次"),
                1, 3, TimeUnit.SECONDS);
    }

    private void multiThreadTest(ExecutorService pool) {

        // 每隔一秒新增一个操作三秒的任务，合计新增十个
        for (int i = 0; i < 10; i++) {

            Utils.delay(1L);

            pool.execute(() -> {
                // 打印正在执行的缓存线程信息
                System.out.println(String.format("%s [%s] 正在被执行",
                        LocalDateTime.now(), Thread.currentThread().getName()));
                Utils.delay(3L);
            });
        }

        // 执行剩余线程 不接受新的线程
        pool.shutdown();

        // 如果存在线程未结束，主线程休眠一秒
        while (!pool.isTerminated()) {
            Utils.delay(1L);
        }
    }
}
