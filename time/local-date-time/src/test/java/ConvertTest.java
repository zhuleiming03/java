import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class ConvertTest {

    @Test
    public void DateAndLocalDateTimeTest() {

        // LocalDateTime to Date
        System.out.println("LocalDateTime to Date:"
                + Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        // Date to LocalDateTime
        Date date = new Date();
        System.out.println("Date to LocalDateTime:" +
                date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
    }

    @Test
    public void LocalDateTimeAndTimestampTest() {

        // LocalDateTime to Timestamp
        long timestamp = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        System.out.println("LocalDateTime to Timestamp:" + timestamp);

        // Timestamp to LocalDateTime
        long second = timestamp / 1000;
        System.out.println("Timestamp to LocalDateTime:" +
                LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault()));
        System.out.println("Timestamp to LocalDateTime:" +
                LocalDateTime.ofInstant(Instant.ofEpochSecond(second), ZoneId.systemDefault()));
    }

    @Test
    public void DateAndTimestampTest() {

        long timestamp = new Date().getTime();

        // Date to Timestamp
        System.out.println("Date to Timestamp:" + timestamp);

        // Timestamp to Date
        System.out.println("Timestamp to Date:" + new Date(timestamp));
    }
}
