package test;


import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import thread.InstanceThread;

import java.util.concurrent.*;

public class BaseTest {

    public static void main(String[] args) {

        // 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，
        // 规避资源耗尽的风险。 说明：Executors各个方法的弊端：
        // 1）newFixedThreadPool 和 newSingleThreadExecutor:
        //  主要问题是堆积的请求处理队列可能会耗费非常大的内存。
        // 2）newCachedThreadPool 和 newScheduledThreadPool:
        // 主要问题是线程数最大数是Integer.MAX_VALUE，可能会创建数量非常多的线程。
        //
        // 创建线程或线程池时请指定有意义的线程名称，方便出错时回溯。
        // 创建线程池的时候请使用带ThreadFactory的构造函数，并且提供自定义ThreadFactory实现或者使用第三方实现。
        ThreadFactory springThreadFactory = new CustomizableThreadFactory("springThread-pool-");


        // 构建线程池
        // corePoolSize  线程池内至少含有线程数量
        // maximumPoolSize 线程池内最多含有线程数量
        // keepAliveTime 线程空闲多长时间后自动结束。
        // unit 线程空闲多长时间的单位
        // workQueue：LinkedBlockingQueue SynchronousQueue
        // LinkedBlockingQueue（无界阻塞队列）队列最大值为Integer.MAX_VALUE。如果任务提交速度持续大余任务处理速度，会造成队列大量阻塞。因为队列很大，很有可能在拒绝策略前，内存溢出。是其劣势；
        // SynchronousQueue（同步队列）这个队列类似于一个接力棒，入队出队必须同时传递，因为 CachedThreadPool 线程创建无限制，不会有队列等待。
        ExecutorService pool = new ThreadPoolExecutor(2, 5, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), springThreadFactory);

        // 执行7个时长1秒的线程
        for (int i = 0; i < COUNT; i++) {
            pool.execute(new InstanceThread());
        }

        // 执行剩余线程 不接受新的线程
        pool.shutdown();

    }

    private static final Integer COUNT = 7;

}
