package test.callable;

import common.Utils;
import thread.Bird;

import java.time.LocalTime;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 通过实现接口 Callable<Integer> 定义一个线程
 * 该线程可返回执行结果
 */
public class CallableTest {

    public static void main(String[] args) {

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
        try {
            System.out.println(String.format("%s [son] 执行结果： %s", LocalTime.now(),
                    futureTask.get(3, TimeUnit.SECONDS)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final Integer COUNT = 3;
}
