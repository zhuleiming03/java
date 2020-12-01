import common.Utils;
import org.junit.Test;
import thread.Cat;
import thread.Cattle;

import java.time.LocalTime;

public class RunnableTest {

    @Test
    public void base() {

        // 1 创建实例
        Cattle cattle = new Cattle();
        Thread son = new Thread(cattle, "son");

        // 2 启动实例
        System.out.println(LocalTime.now() + " : 启动一个子线程");
        son.start();

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            // 主线程休眠3秒
            Utils.delay(3L);
        }
    }

    @Test
    public void multiInstance () {

        // 1 创建多个实例
        Cattle cattle = new Cattle();
        Thread cow = new Thread(cattle, "cow");
        Thread bull = new Thread(cattle, "bull");
        Thread ox = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                System.out.println("This is a son thread :" + Thread.currentThread().getName());
                // 子线程休眠1秒
                Utils.delay(2L);
            }
        });

        // 2 启动多个实例
        cow.start();
        bull.start();
        ox.start();

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            // 主线程休眠3秒
            Utils.delay(3L);
        }
    }

    @Test
    public void multiExtend() {

        // 1 创建实例
        Cat cat = new Cat();
        Thread son = new Thread(cat, "cat");

        // 2 启动实例
        System.out.println(LocalTime.now() + " : 启动一个子线程");
        son.start();

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            // 主线程休眠3秒
            Utils.delay(3L);
        }
    }

    private static final Integer COUNT = 3;
}
