package thread;

import common.Utils;

import java.util.concurrent.Callable;

public class Bird implements Callable<Integer> {

    @Override
    public Integer call() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a son thread :" + Thread.currentThread().getName());
            // 子线程休眠1秒
            Utils.delay(1L);
        }
        return COUNT;
    }

    private static final Integer COUNT = 10;
}
