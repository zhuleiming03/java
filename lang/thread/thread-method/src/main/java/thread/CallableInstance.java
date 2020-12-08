package thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableInstance implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int interval = new Random().nextInt(2000) + 1000;
        Thread.sleep(interval);
        return interval / 1000;
    }
}
