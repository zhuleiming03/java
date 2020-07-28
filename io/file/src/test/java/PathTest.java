import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PathTest {

    @Test
    public void currentDirTest() throws IOException {

        // 第一种：获取类加载的根路径
        // C:\Users\*\java\io\file\target\test-classes
        File f1 = new File(this.getClass().getResource("/").getPath());
        System.out.println(">>1：" + f1);

        // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录
        // C:\Users\*\java\io\file\target\test-classes
        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(">>1：" + f2);

        // 第二种：获取项目路径
        // C:\Users\*\java\io\file
        // 参数为空
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();
        System.out.println(">>2：" + courseFile);

        // 第三种：
        // file:/C:/Users/*/java/io/file/target/test-classes/
        URL xmlPath = this.getClass().getClassLoader().getResource("");
        System.out.println(">>3：" + xmlPath);

        // 第四种： 获取当前工程路径
        // C:\Users\*\java\io\file
        System.out.println(">>4：" + System.getProperty("user.dir"));

        // 第五种：  获取所有的类路径 包括jar包的路径
        System.out.println(">>5：" + System.getProperty("java.class.path"));
    }
}
