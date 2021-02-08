package date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class DateTest {

    @Test
    public void initTest() {

        // 当前时间
        System.out.println(">>当前时间:" + new Date());
    }

    @Test
    public void convertTest() throws ParseException {

        Date date = new Date();

        // String
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String string = formatter.format(date);
        System.out.println("Date -> string :" + string);
        System.out.println("string -> Date :" + formatter.parse(string));
        System.out.println();

        // LocalDate
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println("Date -> LocalDate :" + localDate);
        System.out.println("LocalDate -> Date :" + Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        System.out.println();

        // LocalDateTime
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("Date -> LocalDateTime :" + localDateTime);
        System.out.println("LocalDateTime -> Date :" + Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()));
        System.out.println();

        // LocalTime
        LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        System.out.println("Date -> LocalTime :" + localTime);
        System.out.println("LocalTime -> Date :" + Date.from(localTime.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant()));
        System.out.println();

        // timestamp
        long timestamp = new Date().getTime();
        System.out.println("Date -> Timestamp :" + timestamp);
        System.out.println("Timestamp -> Date :" + new Date(timestamp));
    }
}
