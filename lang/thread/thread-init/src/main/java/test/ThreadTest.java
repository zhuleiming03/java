package test;

import common.Utils;
import thread.Dog;

/**
 * 通过继承 Thread 定义一个线程
 */
public class ThreadTest {

    public static void main(String[] args) {

        // 1 创建实例
        Dog dog = new Dog();

        // 2 启动实例
        dog.start();
        System.out.println("启动一个子线程");

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            // 主线程休眠3秒
            Utils.delay(3L);
        }
    }

    private static final Integer COUNT = 3;
}
