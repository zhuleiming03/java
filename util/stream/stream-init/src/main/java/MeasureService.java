import java.util.function.Function;

class MeasureService {

    static long measure(Function<Long, Long> method, Long n) {

        // 开始时刻
        long start = System.nanoTime();

        // 执行方法
        method.apply(n);

        // 耗时
        long duration = (System.nanoTime() - start) / 1_000_000;
        if (duration < Long.MAX_VALUE) {
            return duration;
        }

        return Long.MAX_VALUE;
    }
}
