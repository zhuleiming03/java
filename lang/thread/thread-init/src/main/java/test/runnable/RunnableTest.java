package test.runnable;

import common.Utils;
import thread.Cattle;

/**
 * 通过实现接口 Runnable 定义两个线程
 */
public class RunnableTest {

    public static void main(String[] args) {

        // 1 创建实例
        Cattle cattle = new Cattle();
        Thread son = new Thread(cattle, "son");
        Thread daughter = new Thread(cattle, "daughter");

        // 2 启动实例
        son.start();
        daughter.start();
        System.out.println("启动两个子线程");

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            // 主线程休眠3秒
            Utils.delay(3L);
        }
    }

    private static final Integer COUNT = 3;
}
