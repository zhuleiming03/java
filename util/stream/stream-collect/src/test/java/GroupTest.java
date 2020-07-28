import org.junit.Test;
import pojo.Bill;
import pojo.BillType;
import pojo.Condition;
import repertory.BillRepertory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class GroupTest {

    /**
     * 根据指定字段分组
     */
    @Test
    public void groupByField() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<BillType, List<Bill>> collect = bills.stream()
                .collect(groupingBy(Bill::getBillType));

        collect.forEach((k, v) -> {
            System.out.printf("Bill type: %s  \n", k);
            v.forEach(System.out::println);
        });
    }

    /**
     * 根据指定对象分组（多个字段分组），需重写 equals hashCode 方法
     */
    @Test
    public void groupByObject() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<Condition, List<Bill>> collect = bills.stream()
                .collect(groupingBy(b -> new Condition(b.getOrderId(), b.getBillType())));

        collect.forEach((k, v) -> {
            System.out.printf("order id: %s bill type: %s \n", k.getOrderId(), k.getBillType());
            v.forEach(System.out::println);
        });
    }

    /**
     * 根据字段分组后继续分组
     */
    @Test
    public void groupByGroup() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<BillType, Map<Long, List<Bill>>> collect = bills.stream()
                .collect(groupingBy(Bill::getBillType,
                        groupingBy(Bill::getOrderId)));

        collect.forEach((k, v) -> {
            System.out.printf("- bill type: %s  \n", k);
            v.forEach((i, j) -> {
                System.out.printf("  order id: %s  \n", i);
                j.forEach(b -> System.out.printf("    %s \n", b));
            });
        });
    }

    /**
     * 根据自定义条件分组
     */
    @Test
    public void groupByCondition() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<String, List<Bill>> collect = bills.stream()
                .collect(groupingBy(bill -> {
                    if (new BigDecimal(1000f).compareTo(bill.getAmount()) > 0) return "A";
                    else if (new BigDecimal(3000f).compareTo(bill.getAmount()) > 0) return "B";
                    else return "C";
                }));

        collect.forEach((k, v) -> {
            System.out.printf("Bill type: %s  \n", k);
            v.forEach(System.out::println);
        });
    }

    /**
     * 根据条件分成 满足条件和不满足条件的两组
     */
    @Test
    public void partition() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<Boolean, List<Bill>> collect = bills.stream().
                collect(partitioningBy(bill -> bill.getPeriods() > 5));

        List<Bill> vegetarian = collect.get(true);

        vegetarian.forEach(System.out::println);
    }
}


