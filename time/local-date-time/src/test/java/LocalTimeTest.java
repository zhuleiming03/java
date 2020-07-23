import org.junit.Test;

import java.time.LocalTime;

public class LocalTimeTest {

    @Test
    public void initTest(){
        System.out.println(">>当前时间:" + LocalTime.now());

        System.out.println(">>无毫秒的当期时间:" + LocalTime.now().withNano(0));

        System.out.println(">>时分秒指定时间:" + LocalTime.of(4, 45, 50));

        System.out.println(">>字符串指定时间:" + LocalTime.parse("12:13:14"));
    }
}
