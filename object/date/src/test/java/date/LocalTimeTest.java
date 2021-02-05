package date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
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
    }

    @Test
    public void convertTest() {

        LocalTime now = LocalTime.now();

        // String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH 时 mm 分 ss 秒");
        String string = formatter.format(now);
        System.out.println("LocalTime -> String :" + string);
        System.out.println("String -> LocalTime :" + LocalTime.parse(string, formatter));
        System.out.println();

        // Date
        Date date = Date.from(now.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalTime -> Date :" + date);
        System.out.println("Date -> LocalTime :" + new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalTime());
        System.out.println();

        // LocalDateTime
        LocalDateTime localDateTime = now.atDate(LocalDate.now());
        System.out.println("LocalTime -> localDateTime :" + localDateTime);
        System.out.println("localDateTime -> LocalTime :" + localDateTime.toLocalTime());
    }
}
