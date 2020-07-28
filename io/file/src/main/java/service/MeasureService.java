package service;

import java.util.function.Function;

public class MeasureService {

    public static String measureRead(Function<String, String> method, String url) {

        // 开始时刻
        long start = System.nanoTime();

        // 执行方法
        String result = method.apply(url);

        // 耗时
        long duration = (System.nanoTime() - start) / 1_000;
        if (duration < Long.MAX_VALUE) {
            System.out.printf(">> 耗时统计:%4d ", duration);
        }

        return result;
    }
}
