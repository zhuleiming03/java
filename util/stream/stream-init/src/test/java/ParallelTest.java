import org.junit.Test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelTest {

    /**
     * 累加计算耗时测试
     */
    @Test
    public void capacityTest() {

        long count = 100_000_000L;

        System.out.println("method【for】                 need time is "
                + MeasureService.measure(SumService::sumFor, count));

        // 多线程 rangeClosed
        System.out.println("method【多线程 rangeClosed】  need time is "
                + MeasureService.measure(SumService::parallelRanged, count));

        // 单线程 rangeClosed
        System.out.println("method【单线程 rangeClosed】  need time is "
                + MeasureService.measure(SumService::sequentialRanged, count));

        // 拆装箱 rangeClosed
        System.out.println("method【拆装箱 rangeClosed】  need time is "
                + MeasureService.measure(SumService::streamIterate, count));

        // 多线程 iterate
        System.out.println("method【多线程 iterate】      need time is "
                + MeasureService.measure(SumService::parallelIterate, count));

        // 单线程 iterate
        System.out.println("method【单线程 iterate】      need time is "
                + MeasureService.measure(SumService::sequentialIterate, count));

    }
}
