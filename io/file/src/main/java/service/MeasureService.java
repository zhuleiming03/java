package service;

import java.io.IOException;
import java.util.function.Function;

public class MeasureService {

    public static String measureRead(Function<String, String> method, String url) {

        // 开始时刻
        long start = System.nanoTime();

        // 执行方法
        String result = method.apply(url);

        // 耗时
        long duration = (System.nanoTime() - start) / 1_000;
        System.out.printf(">> 耗时统计:%4d ", duration);

        return result;
    }

    public static <C> void measureWrite(TimeTool<Boolean, String, String, C> method, String path, String fileName, C content) throws IOException {

        // 开始时刻
        long start = System.nanoTime();

        // 执行方法
        method.apply(path, fileName, content);

        // 耗时
        long duration = (System.nanoTime() - start) / 1_000;
        System.out.printf(">> 耗时统计:%4d ", duration);
    }

}
