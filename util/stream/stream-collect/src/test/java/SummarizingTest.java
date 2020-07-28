import org.junit.Test;
import pojo.Bill;
import pojo.BillType;
import repertory.BillRepertory;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;


public class SummarizingTest {

    /**
     * 统计个数
     */
    @Test
    public void count() {

        List<Bill> bills = new BillRepertory().getDefault();

        long count = bills.stream()
                .filter(b -> BillType.FINISH.equals(b.getBillType()))
                .count();

        System.out.println("total: " + count);
    }

    /**
     * 获得合计值
     */
    @Test
    public void sum() {

        List<Bill> bills = new BillRepertory().getDefault();

        int sumInt = bills.stream().mapToInt(Bill::getPeriods).sum();
        System.out.println("periods sum : " + sumInt);

        BigDecimal sumBigDecimal = bills.stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("amount sum : " + sumBigDecimal);
    }

    /**
     * 获取最小值和对象
     */
    @Test
    public void min() {

        List<Bill> bills = new BillRepertory().getDefault();

        BigDecimal min = bills.stream()
                .map(Bill::getAmount)
                .min(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        System.out.println("min: " + min);

        Optional<Bill> collect = bills.stream()
                .min(Comparator.comparing(Bill::getAmount));
        System.out.println("max object: " + collect);
    }

    /**
     * 获得平均数
     */
    @Test
    public void averaging() {

        List<Bill> bills = new BillRepertory().getDefault();

        Double averageInt = bills.stream().collect(averagingInt(Bill::getPeriods));
        System.out.println("periods average : " + averageInt);
    }

    /**
     * 获取最大值和对象
     */
    @Test
    public void max() {

        List<Bill> bills = new BillRepertory().getDefault();

        BigDecimal max = bills.stream()
                .map(Bill::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
        System.out.println("max: " + max);

        Optional<Bill> collect = bills.stream()
                .max(Comparator.comparing(Bill::getAmount));
        System.out.println("max object: " + collect);
    }

    /**
     * 获取统计明细
     */
    @Test
    public void summarizing() {

        List<Bill> bills = new BillRepertory().getDefault();

        IntSummaryStatistics collect = bills.stream().collect(summarizingInt(Bill::getPeriods));

        System.out.println("summarizing : " + collect);
    }
}
