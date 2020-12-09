package test.thread;

import java.time.LocalTime;

/**
 * thread.join()
 * 在当前线程中加入指定线程，使得这个指定线程等待当前线程，并在当前线程结束前结束。
 * join()方法常用来保证：确保能够完整的获取到插队线程的处理结果。
 */
public class JoinTest {

    public static void main(String[] args) {

        System.out.println(LocalTime.now() + " : 主线程开始");

        // 模拟接口调用
        Thread invoke = new Thread(() -> {
            delay(1000L);
            System.out.println(LocalTime.now() + " : 接口调用成功");
        });

        // 模拟文件获取
        Thread file = new Thread(() -> {
            delay(1500L);
            System.out.println(LocalTime.now() + " : 文件获取成功");
        });

        // 模拟数据保存
        Thread data = new Thread(() -> {
            delay(200L);
            System.out.println(LocalTime.now() + " : 数据保存成功");
        });

        invoke.start();
        file.start();
        data.start();

        // 三个线程并行操作 只需等待最大耗时线程时间 1.5s
        try {
            invoke.join();
            file.join();
            data.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalTime.now() + " : 主线程结束");
    }

    private static void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
