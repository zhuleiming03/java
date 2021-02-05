package date;

import org.junit.Test;

import java.time.*;
import java.util.Date;

public class DateTest {

    @Test
    public void initTest() {

        // 当前时间
        System.out.println(">>当前时间:" + new Date());
    }

    @Test
    public void convertTest() {

        Date date = new Date();

        // String

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
    }

    @Test
    public void timestampTest(){

        long timestamp = new Date().getTime();

        // Date to Timestamp
        System.out.println("Date to Timestamp:" + timestamp);

        // Timestamp to Date
        System.out.println("Timestamp to Date:" + new Date(timestamp));

//        // LocalDateTime to Timestamp
//        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
//        System.out.println("LocalDateTime to Timestamp:" + timestamp);
//
//        // Timestamp to LocalDateTime
//        long second = timestamp / 1000;
//        System.out.println("Timestamp to LocalDateTime:" +
//                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()));
//        System.out.println("Timestamp to LocalDateTime:" +
//                LocalDateTime.ofInstant(Instant.ofEpochSecond(second), ZoneId.systemDefault()));
    }
}
