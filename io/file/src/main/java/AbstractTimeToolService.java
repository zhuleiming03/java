
import java.io.IOException;

public abstract class AbstractTimeToolService {

    private Long start;

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
        start = System.nanoTime();
    }

    private void after() {
        long duration = (System.nanoTime() - start) / 1_000;
        if (duration < Long.MAX_VALUE) {
            System.out.printf(">> 耗时统计:%4d ", duration);
        }
    }
}
