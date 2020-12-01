import common.Utils;
import org.junit.Test;
import thread.Bird;

import java.time.LocalTime;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class ThreadTest {

    @Test
    public void base() throws Exception {

        // 1 创建实例
        Bird bird = new Bird();
        FutureTask<Integer> futureTask = new FutureTask<>(bird);

        // 2 启动实例
        System.out.println(LocalTime.now() + " : 启动一个子线程");
        new Thread(futureTask, "son").start();

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            // 主线程休眠3秒
            Utils.delay(3L);
        }

        // 4 返回子线程的结果
        System.out.println(String.format("%s [son] 执行结果： %s", LocalTime.now(),
                futureTask.get(3, TimeUnit.SECONDS)));
    }

    private static final Integer COUNT = 3;
}