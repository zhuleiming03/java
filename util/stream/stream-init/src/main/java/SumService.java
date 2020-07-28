import java.util.stream.LongStream;
import java.util.stream.Stream;

class SumService {

    static long sumFor(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    static Long sequentialIterate(long n) {
        return LongStream.iterate(1L, i -> i + 1).limit(n).
                reduce(0L, Long::sum);
    }

    static Long parallelIterate(long n) {
        return LongStream.iterate(1L, i -> i + 1).limit(n).parallel().
                reduce(0L, Long::sum);
    }

    static Long streamIterate(Long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).
                reduce(0L, Long::sum);
    }

    static Long sequentialRanged(long n) {
        return LongStream.rangeClosed(1L, n).
                reduce(0L, Long::sum);
    }

    static Long parallelRanged(long n) {
        return LongStream.rangeClosed(1L, n).parallel().
                reduce(0L, Long::sum);
    }
}
