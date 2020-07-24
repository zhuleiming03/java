import org.junit.Test;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalTimeTest {

    @Test
    public void initTest() {

        // 当前时间
        System.out.println(">>当前时间:" + LocalTime.now());

        // 无毫秒的当期时间
        System.out.println(">>无毫秒的当期时间:" + LocalTime.now().withNano(0));

        // 时分秒指定时间
        System.out.println(">>时分秒指定时间:" + LocalTime.of(4, 45, 50));

        // 字符串指定时间
        System.out.println(">>字符串指定时间:" + LocalTime.parse("12:13:14"));

        // 根据Date转化时间
        Instant instant = new Date().toInstant();
        System.out.println(">>根据Date转化日期时间:" + instant.atZone(ZoneId.systemDefault()).toLocalTime());
    }
}
