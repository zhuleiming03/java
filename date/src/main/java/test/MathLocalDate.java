package test;

import service.WorkDayService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;

import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class MathLocalDate {

    public static void main(String[] args) {
        between();
        alter();
        with();
    }

    /**
     * 日期差计算
     */
    private static void between() {
        System.out.println("--- 日期差计算 ---");
        LocalDate date1 = LocalDate.of(2020, 3, 1);
        LocalDate date2 = LocalDate.of(2020, 1, 28);
        Period timeSpace = Period.between(date2, date1);
        System.out.printf("【%s】和【%s】相差【%s】年【%s】月【%s】天\n",
                date1, date2, timeSpace.getYears(), timeSpace.getMonths(), timeSpace.getDays());
    }

    /**
     * 年月日修改计算
     */
    private static void alter() {
        System.out.println("--- 加减计算 ---");
        LocalDate today = LocalDate.now();
        System.out.printf("【%s】加一天：【%s】\n",
                today, today.plusDays(1));

        System.out.printf("【%s】减一月：【%s】\n",
                today, today.minusMonths(1));

        System.out.printf("【%s】修改年：【%s】\n",
                today, today.withYear(2008));
    }

    /**
     * 自定义时间逻辑计算
     */
    private static void with() {
        System.out.println("--- 自定义时间逻辑计算 ---");
        // 获取最近的一个周五
        LocalDate friday = LocalDate.now().with(nextOrSame(DayOfWeek.FRIDAY));
        System.out.printf("【%s】后一个工作日：【%s】\n",
                friday, friday.with(new WorkDayService()));
    }
}
