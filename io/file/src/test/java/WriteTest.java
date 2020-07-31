import org.junit.Test;
import repertory.WriteContextRepertory;
import service.FileService;
import service.MeasureService;

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

        System.out.println("FileOutputStream：通过字节写入数据");
        MeasureService.measureWrite(FileService::writeFileByFileOutputStream,resourcesPath,
                "FileOutputStream.txt", contentStringBuilder.getBytes());

        System.out.println("OutputStreamWriter：通过字符写入数据,可指定编码格式");
        MeasureService.measureWrite(FileService::writeFileByOutputStreamWriter,resourcesPath,
                "OutputStreamWriter.txt", contentStringBuilder);


        System.out.println("BufferedWriter：通过缓存写入字符数据，可指定编码格式");
        MeasureService.measureWrite(FileService::writeFileByBufferedWriter,resourcesPath,
                "BufferedWriter.txt", contentStringBuilder);

        System.out.println("FileWriter：通过缓存写入字符数据，不可指定编码格式");
        MeasureService.measureWrite(FileService::writeFileByFileWriter,resourcesPath,
                "FileWriter.txt", contentStringBuilder);
    }
}
