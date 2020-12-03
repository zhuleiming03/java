import common.Utils;
import org.junit.Test;

/**
 * 使线程暂停并重新开始竞争CPU
 */
public class YieldTest {

    @Test
    public void baseTest() {

        Thread instance = new Thread(() -> {
            for (int i = 0; i <= 49; i++) {
                if (i % 10 == 0) {
                    // 每当 i 能被 10 整除时 释放锁 重新竞争 CPU
                    System.out.println(String.format("[%s] %s",
                            Thread.currentThread().getName(), i));
                    Thread.yield();
                }
            }
        });

        Thread one = new Thread(instance, "one");
        Thread two = new Thread(instance, "two");

        one.start();
        two.start();

        Utils.delay(2L);
    }
}
