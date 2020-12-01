import common.Utils;
import org.junit.Test;
import thread.Dog;

import java.time.LocalTime;

public class CallableTest {

    @Test
    public void base() {

        // 1 创建实例
        Dog dog = new Dog();

        // 2 启动实例
        System.out.println(LocalTime.now() + " : 启动一个子线程");
        dog.start();

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            // 主线程休眠3秒
            Utils.delay(3L);
        }
    }

    private static final Integer COUNT = 3;
}
