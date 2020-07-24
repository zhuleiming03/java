import org.junit.Test;

import java.time.*;

import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class MathTest {

    /**
     * 日期时间差计算
     */
    @Test
    public void betweenTest() {

        System.out.println("--- 日期差计算 ---");
        LocalDate date1 = LocalDate.of(2020, 3, 1);
        LocalDate date2 = LocalDate.of(2020, 1, 28);
        Period period = Period.between(date2, date1);
        System.out.printf("【%s】和【%s】相差【%s】年【%s】月【%s】天\n",
                date1, date2, period.getYears(), period.getMonths(), period.getDays());

        System.out.println("--- 时间差计算 ---");
        LocalTime time1 = LocalTime.of(12, 12, 31);
        LocalTime time2 = LocalTime.of(12, 13, 12);
        Duration duration = Duration.between(time1, time2);
        System.out.printf("【%s】和【%s】相差【%s】秒\n",
                time1, time2, duration.getSeconds());
    }

    /**
     * 年月日修改计算
     */
    @Test
    public void computeTest() {
        LocalDate today = LocalDate.now();
        System.out.printf("【%s】加一天：【%s】\n", today, today.plusDays(1));
        System.out.printf("【%s】减一月：【%s】\n", today, today.minusMonths(1));
        System.out.printf("【%s】修改年：【%s】\n", today, today.withYear(2008));
    }

    /**
     * 自定义时间逻辑计算
     */
    @Test
    public void withTest() {
        System.out.println("--- 自定义时间逻辑计算 ---");
        // 获取最近的一个周五
        LocalDate friday = LocalDate.now().with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.printf("【%s】后一个工作日：【%s】\n",
                friday, friday.with(new WorkDayService()));
    }
}
