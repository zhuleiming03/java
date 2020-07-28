import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class WriteTest {

    @Test
    public void writeTxt() throws IOException {

        // 获取文件路径
        String resourcesPath = String.format("%s\\src\\main\\resources\\write",
                new File("").getCanonicalPath());

        // 获取数据源
        String contentStringBuilder = new WriteContextRepertory().getContext();

        // BufferedOutputStream 最慢
        // OutputStreamWriter 其次
        // BufferedWriter 高 优先
        // OutputStreamWriter.FileWriter 高 缺点 不能指定编码方式
        AbstractTimeToolService service;

        System.out.println("FileOutputStream：通过字节写入数据");
        service = new AbstractTimeToolService() {
            @Override
            public void work() throws IOException {
                FileService.writeFileByFileOutputStream(resourcesPath,
                        "FileOutputStream.txt", contentStringBuilder.getBytes());
            }
        };

        service.doWork();

        System.out.println("OutputStreamWriter：通过字符写入数据,可指定编码格式");
        service = new AbstractTimeToolService() {
            @Override
            public void work() throws IOException {
                FileService.writeFileByOutputStreamWriter(resourcesPath,
                        "OutputStreamWriter.txt", contentStringBuilder);
            }
        };
        service.doWork();

        System.out.println("BufferedWriter：通过缓存写入字符数据，可指定编码格式");
        service = new AbstractTimeToolService() {
            @Override
            public void work() throws IOException {
                FileService.writeFileByBufferedWriter(resourcesPath,
                        "BufferedWriter.txt", contentStringBuilder);
            }
        };
        service.doWork();

        System.out.println("FileWriter：通过缓存写入字符数据，不可指定编码格式");
        service = new AbstractTimeToolService() {
            @Override
            public void work() throws IOException {
                FileService.writeFileByFileWriter(resourcesPath,
                        "FileWriter.txt", contentStringBuilder);
            }
        };
        service.doWork();
    }
}
