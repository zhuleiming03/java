package test.executorService;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，支持定时及周期性任务执行——延迟执行
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {

        // pool 等价于 scheduledThreadPoolExecutor
        ScheduledExecutorService scheduledThreadPoolExecutor = Executors.newScheduledThreadPool(5);
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(3);

        System.out.println(LocalTime.now() + "----------- begin ------------");
        //延迟1秒后每2秒执行一次
        pool.scheduleAtFixedRate(() -> System.out.println(LocalTime.now() + " 延迟1秒后每2秒执行一次"),
                1, 2, TimeUnit.SECONDS);
    }
}
