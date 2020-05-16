package test;

import java.time.Duration;
import java.time.LocalTime;

public class MathLocalTime {

    public static void main(String[] args) {
        between();
    }

    private static void between() {
        System.out.println("--- 时间差计算 ---");
        LocalTime time1 = LocalTime.of(12, 12, 31);
        LocalTime time2 = LocalTime.of(12, 13, 12);
        Duration timeSpace = Duration.between(time1, time2);
        System.out.printf("【%s】和【%s】相差【%s】秒\n",
                time1, time2, timeSpace.getSeconds());
    }
}
