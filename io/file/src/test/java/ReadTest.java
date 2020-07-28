import org.junit.Test;
import service.FileService;
import service.MeasureService;

import java.io.File;
import java.io.IOException;

public class ReadTest {

    @Test
    public void readTxt() throws IOException {

        // 获取文件路径
        String resourcesPath = String.format("%s\\src\\main\\resources\\read\\",
                new File("").getCanonicalPath());

        System.out.println("--- 读取文本信息 ---");

        // InputStream 能从来源处一个个读取 byte, 效率最低
        // InputStreamReader 能从来源处一个个读取 char, 效率居中
        // BufferedReader 能从来源处一行行读取 char, 效率最高

        System.out.printf("通过字符来读取文本：\n%s\n",
                MeasureService.measureRead(FileService::readFileByChar, resourcesPath + "article.txt"));

        System.out.printf("通过行来读取文本：\n%s\n",
                MeasureService.measureRead(FileService::readFileByLine, resourcesPath + "article.txt"));
    }

    @Test
    public void readByte() throws IOException{

        // 获取文件路径
        String resourcesPath = String.format("%s\\src\\main\\resources\\read\\",
                new File("").getCanonicalPath());

        System.out.println("--- 读取非文本信息 ---");

        // 定义一个 byteBlock 每次读取一个 byteBlock 来提升效率
        byte[] bytes = FileService.readFileByBytes(resourcesPath + "image.jpg");
        assert bytes != null;
        System.out.printf("通过 byteBlock 来读取非文本, 合计 %s 个字节\n", bytes.length);
    }
}
