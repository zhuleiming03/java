import org.junit.Test;
import pojo.Bill;
import pojo.BillType;
import repertory.BillRepertory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class GroupSummarizingTest {

    /**
     * 分组统计个数
     */
    @Test
    public void groupByCount() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<BillType, Long> collect = bills.stream()
                .collect(groupingBy(Bill::getBillType, counting()));

        collect.forEach((k, v) -> {
            System.out.printf("Bill type: %s  count: %s \n", k, v);
        });
    }

    /**
     * 分组统计最大金额对象
     */
    @Test
    public void groupByMax() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<BillType, Bill> collect = bills.stream()
                .collect(toMap(Bill::getBillType, Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Bill::getAmount))));

        collect.forEach((k, v) -> System.out.printf("Bill type: %s  max amount: %s \n", k, v.getAmount()));
    }

    /**
     * 分组统计求和
     */
    @Test
    public void groupBySum() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<Long, Double> collect = bills.stream()
                .collect(groupingBy(Bill::getOrderId, summingDouble(bill -> bill.getAmount().doubleValue())));

        collect.forEach((k, v) -> System.out.printf("order id: %s  total amount: %s \n", k, v));
    }
}
