package test;

import org.apache.commons.lang3.time.StopWatch;
import service.FileService;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReadTest {

    public static void main(String[] args) throws IOException {

        String resourcesPath = String.format("%s\\src\\main\\resources\\read\\",
                new File("").getCanonicalPath());

        String result;

        System.out.println("--- 读取文本信息 ---");

        // InputStream 能从来源处一个个读取 byte, 效率最低
        // InputStreamReader 能从来源处一个个读取 char, 效率居中
        // BufferedReader 能从来源处一行行读取 char, 效率最高
        StopWatch stopwatch = StopWatch.createStarted();
        result = FileService.readFileByChar(resourcesPath + "article.txt");
        stopwatch.stop();
        assert result != null;
        System.out.printf("通过字符来读取文本（耗时：%s 毫秒）：\n%s\n",
                stopwatch.getTime(TimeUnit.MILLISECONDS), result);

        stopwatch.reset();
        stopwatch.start();
        result = FileService.readFileByLine(resourcesPath + "article.txt");
        stopwatch.stop();
        assert result != null;
        System.out.printf("通过字符来读取文本（耗时：%s 毫秒）：\n%s\n",
                stopwatch.getTime(TimeUnit.MILLISECONDS), result);

        System.out.println("--- 读取非文本信息 ---");

        // 定义一个 byteBlock 每次读取一个 byteBlock 来提升效率
        byte[] bytes = FileService.readFileByBytes(resourcesPath + "image.jpg");
        assert bytes != null;
        System.out.printf("通过 byteBlock 来读取非文本, 合计 %s 个字节\n", bytes.length);
    }
}
