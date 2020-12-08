package test.callable;

import common.Utils;
import thread.Bird;

import java.time.LocalTime;
import java.util.concurrent.*;

public class CallablePoolTest {

    public static void main(String[] args) {

        // 1 创建线程池
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024));

        // 2 创建实例
        Future<Integer> future = executor.submit(new Bird());

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            // 主线程休眠3秒
            Utils.delay(3L);
        }

        // 4 返回子线程的结果
        try {
            System.out.println(String.format("%s [son] 执行结果： %s", LocalTime.now(), future.get()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 5 关闭线程池
        executor.shutdownNow();
    }

    private static final Integer COUNT = 3;
}
