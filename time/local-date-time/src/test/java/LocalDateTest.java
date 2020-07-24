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

        // 根据文本转化日期
        System.out.println(">>文本转化日期:" + LocalDate.parse("2019-03-28"));

        // 根据Date转化日期
        Instant instant = new Date().toInstant();
        System.out.println(">>Date转化日期:" + instant.atZone(ZoneId.systemDefault()).toLocalDate());
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

    @Test
    public void convertTest() {

        LocalDate today = LocalDate.now();

        // 转成 localDateTime 格式
        LocalDateTime localDateTime = today.atTime(LocalTime.now());
        System.out.println(">>localDateTime 格式:" + localDateTime);

        // 转成 String 格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String text = formatter.format(today);
        System.out.println(">>字符串 格式:" + text);

        // 转成 Date 格式
        ZonedDateTime zonedDateTime = today.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(">>Date 格式:" + date);
    }
}
