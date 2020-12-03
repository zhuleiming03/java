import common.Utils;
import org.junit.Test;

import java.time.LocalTime;

/**
 * 等待线程结束
 */
public class JoinTest {

    @Test
    public void baseTest() {

        System.out.println(LocalTime.now() + " : 主线程开始");

        // 子线程开始
        Thread son = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(LocalTime.now() + " : 子线程运行");
            }
        });
        son.start();

        //等待 子线程 执行完后 才能执行主线程
        try {
            son.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalTime.now() + " : 主线程结束");
    }

    @Test
    public void multiTest() {

        System.out.println(LocalTime.now() + " : 主线程开始");

        // 模拟接口调用
        Thread invoke = new Thread(() -> {
            Utils.delay(1L);
            System.out.println(LocalTime.now() + " : 接口调用成功");
        });

        // 模拟文件获取
        Thread file = new Thread(() -> {
            Utils.delay(5L);
            System.out.println(LocalTime.now() + " : 文件获取成功");
        });

        // 模拟数据保存
        Thread data = new Thread(() -> {
            Utils.delay(2L);
            System.out.println(LocalTime.now() + " : 数据保存成功");
        });

        invoke.start();
        file.start();
        data.start();

        // 三个线程并行操作 只需等待最大耗时线程时间
        try {
            invoke.join();
            file.join();
            data.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalTime.now() + " : 主线程结束");
    }
}
