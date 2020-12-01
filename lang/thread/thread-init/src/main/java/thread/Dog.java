package thread;

import common.Utils;

public class Dog extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a son thread :" + Thread.currentThread().getName());
            // 子线程休眠1秒
            Utils.delay(1L);
        }
    }

    private static final Integer COUNT = 10;
}
