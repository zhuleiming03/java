import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeTest {

    @Test
    public void initTest() {

        // 当前日期时间
        LocalDateTime today = LocalDateTime.now();
        System.out.println(">>当前日期时间:" + today);

        // 年月日时分秒指定时间
        LocalDateTime dateYmd = LocalDateTime.of(1990, 5, 15, 12, 45, 21);
        System.out.println(">>年月日时分秒指定时间:" + dateYmd);

        // 根据文本转化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(">>文本转化日期1:" + LocalDateTime.parse("2019-03-28T15:12:11"));
        System.out.println(">>文本转化日期2:" + LocalDateTime.parse("2019-03-28 15:12:11", formatter));

        // 根据Date转化日期时间
        Instant instant = new Date().toInstant();
        System.out.println(">>根据Date转化日期时间:" + instant.atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    @Test
    public void convertTest() {

        LocalDateTime today = LocalDateTime.now();

        // 转成 localDate 格式
        LocalDate localDate = today.toLocalDate();
        System.out.println(">>localDate 格式:" + localDate);

        // 转成 localTime 格式
        LocalTime localTime = today.toLocalTime();
        System.out.println(">>localTime 格式:" + localTime);

        // 转成 String 格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(">>字符串 格式:" + formatter.format(today));
    }
}
