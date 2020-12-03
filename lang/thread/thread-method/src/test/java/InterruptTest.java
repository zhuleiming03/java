import common.Utils;
import org.junit.Test;

import java.time.LocalTime;

/**
 * 中断线程
 */
public class InterruptTest {

    @Test
    public void baseTest() {

        System.out.println(LocalTime.now() + " : 主线程开始");

        // 子线程开始
        Thread son = new Thread(() -> {
            System.out.println(LocalTime.now() + " : 子线程开始");
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(LocalTime.now() + " : 子线程中断");
                    break;
                }
            }
            System.out.println(LocalTime.now() + " : 子线程结束");
        });
        son.start();

        // 主进程休眠1秒
        Utils.delay(1L);

        // 子线程中断
        son.interrupt();

        System.out.println(LocalTime.now() + " : 主线程结束");
    }
}
