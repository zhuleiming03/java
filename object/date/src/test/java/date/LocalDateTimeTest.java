package date;

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
    }

    @Test
    public void convertTest() {

        LocalDateTime today = LocalDateTime.now();

        // String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String string = formatter.format(today);
        System.out.println("LocalDateTime -> String :" + string);
        System.out.println("String -> LocalDateTime :" + LocalDateTime.parse(string, formatter));
        System.out.println();

        // Date
        Date date = Date.from(today.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime -> Date :" + date);
        System.out.println("Date -> LocalDateTime :" + new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        System.out.println();

        // LocalDate
        LocalDate localDate = today.toLocalDate();
        System.out.println("LocalDateTime -> LocalDate :" + localDate);
        System.out.println("LocalDate -> LocalDateTime :" + localDate.atTime(LocalTime.now()));
        System.out.println();

        // LocalTime
        LocalTime localTime = today.toLocalTime();
        System.out.println("LocalDateTime -> localTime :" + localTime);
        System.out.println("localTime -> LocalDateTime :" + localTime.atDate(LocalDate.now()));
        System.out.println();

        // timestamp
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("LocalDateTime -> Timestamp :" + timestamp);
        System.out.println("Timestamp -> LocalDateTime :" + LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()));
    }
}
