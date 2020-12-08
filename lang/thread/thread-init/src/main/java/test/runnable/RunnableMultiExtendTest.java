package test.runnable;

import common.Utils;
import thread.Cat;

/**
 * 通过实现接口 Runnable 定义一个线程
 * 该线程可实现多继承
 */
public class RunnableMultiExtendTest {

    public static void main(String[] args){
        // 1 创建实例
        Cat cat = new Cat();
        Thread son = new Thread(cat, "cat");

        // 2 启动实例
        System.out.println("启动一个子线程");
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
