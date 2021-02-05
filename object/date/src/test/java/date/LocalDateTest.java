package date;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class LocalDateTest {

    @Test
    public void initTest() {

        // 当前日期
        System.out.println(">>当前日期:" + LocalDate.now());

        // 年月日指定日期
        System.out.println(">>年月日指定日期:" + LocalDate.of(1990, 5, 15));
    }

    @Test
    public void convertTest() {

        LocalDate today = LocalDate.now();

        // String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String string = formatter.format(today);
        System.out.println("LocalDate -> String :" + string);
        System.out.println("String -> LocalDate :" + LocalDate.parse(string, formatter));
        System.out.println();

        // Date
        Date date = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDate -> Date :" + date);
        System.out.println("Date -> LocalDate :" + new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println();

        // LocalDateTime
        LocalDateTime localDateTime = today.atTime(LocalTime.now());
        System.out.println("LocalDate -> LocalDateTime :" + localDateTime);
        System.out.println("LocalDateTime -> LocalDate :" + localDateTime.toLocalDate());
    }

    @Test
    public void methodTest() {

        LocalDate today = LocalDate.now();

        // 取本月第1天：
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(">>月首:" + firstDayOfThisMonth);

        // 取本月第N天：
        LocalDate thirdDayOfThisMonth = today.withDayOfMonth(3);
        System.out.println(">>本月第3天:" + thirdDayOfThisMonth);

        // 取本月最后一天，再也不用计算是28，29，30还是31：
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(">>月尾:" + lastDayOfThisMonth);

        // 取当月天数
        int monthDay = today.lengthOfMonth();
        System.out.println(String.format(">>本月合计:%d 天", monthDay));
    }


}
