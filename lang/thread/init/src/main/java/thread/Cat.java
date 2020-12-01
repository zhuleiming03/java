package thread;

import common.Utils;
import service.Pet;

public class Cat implements Runnable, Pet {

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a son thread :" + master());
            // 子线程休眠1秒
            Utils.delay(1L);
        }
    }

    @Override
    public String master() {
        return "cat's master is Sean";
    }

    private static final Integer COUNT = 7;
}
