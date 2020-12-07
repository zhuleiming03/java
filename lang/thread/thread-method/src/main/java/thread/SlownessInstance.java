package thread;

import common.Utils;

public class SlownessInstance implements Runnable {

    @Override
    public void run() {
        Utils.delay(2);
        System.out.println("线程是否守护线程: " + Thread.currentThread().isDaemon());
    }
}
