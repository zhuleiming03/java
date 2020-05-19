package service;

import org.apache.commons.lang3.time.StopWatch;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTimeToolService {

    private StopWatch stopwatch;

    public AbstractTimeToolService() {
        stopwatch = StopWatch.createStarted();
    }

    public void doWork() {
        before();
        try {
            work();
        } catch (IOException e) {
            e.printStackTrace();
        }
        after();
    }

    public abstract void work() throws IOException;

    private void before() {
        stopwatch.reset();
        stopwatch.start();
    }

    private void after() {
        stopwatch.stop();
        System.out.printf("耗时: %s 毫秒\n",
                stopwatch.getTime(TimeUnit.MILLISECONDS));
    }
}
