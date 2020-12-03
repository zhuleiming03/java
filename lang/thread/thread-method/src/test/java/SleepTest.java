import org.junit.Test;

import java.time.LocalTime;

/**
 * 使线程休眠指定时间
 */
public class SleepTest {

    @Test
    public void baseTest() {

        System.out.println(LocalTime.now() + " : 主线程开始");

        // 线程休眠三秒
        try {
            Thread.sleep(1000L * 3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalTime.now() + " : 主线程结束");
    }
}
