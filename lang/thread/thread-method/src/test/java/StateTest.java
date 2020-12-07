import common.Utils;
import org.junit.Test;

public class StateTest {

    /**
     * Java 线程的 6 种状态 ??? 5种
     */
    @Test
    public void baseTest() {

        Thread instance = new Thread(() -> {
            // 运行状态(Running)
            System.out.println("state:" + Thread.currentThread().getState());
            Utils.delay(2L);
        });

        Thread first = new Thread(() -> Utils.delay(2L));
        first.setPriority(1);

        // 新建状态(New)
        System.out.println("state:" + instance.getState());

        // 就绪状态(Runnable)
        instance.start();
        System.out.println("state:" + instance.getState());
        first.start();

        // 阻塞状态(Blocked)
        Utils.delay(1L);
        System.out.println("state:" + instance.getState());

        // 死亡状态(Terminate)
        Utils.delay(3L);
        System.out.println("state:" + instance.getState());
    }
}
