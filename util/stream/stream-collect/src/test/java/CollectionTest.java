import org.junit.Test;
import pojo.Bill;
import pojo.BillType;
import repertory.BillRepertory;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectionTest {

    /**
     * 筛选结果成 List
     */
    @Test
    public void list() {

        List<Bill> bills = new BillRepertory().getDefault();

        List<Bill> collect = bills.stream()
                .filter(b -> BillType.OVERDUE.equals(b.getBillType()))
                .collect(toList());

        collect.forEach(System.out::println);
    }


    /**
     * 筛选结果成 Set
     */
    @Test
    public void set() {

        List<Bill> bills = new BillRepertory().getDefault();

        Set<Bill> collect = bills.stream()
                .filter(b -> BillType.OVERDUE.equals(b.getBillType()))
                .collect(toSet());

        collect.forEach(System.out::println);
    }

    /**
     * 筛选结果成 ArrayList
     */
    @Test
    public void arrayList() {

        List<Bill> bills = new BillRepertory().getDefault();

        ArrayList<Bill> collect = bills.stream()
                .filter(b -> BillType.OVERDUE.equals(b.getBillType()))
                .collect(toCollection(ArrayList::new));

        collect.forEach(System.out::println);
    }

    /**
     * 筛选结果成 may
     */
    @Test
    public void may() {

        List<Bill> bills = new BillRepertory().getDefault();

        Map<Long, Bill> collect = bills.stream()
                .filter(b -> BillType.OVERDUE.equals(b.getBillType()))
                .collect(toMap(Bill::getOrderId, Function.identity()));

        collect.forEach((k, v) -> {
            System.out.printf("order id: %s %s  \n", k, v);
        });
    }

    /**
     * 筛选结果成 string
     */
    @Test
    public void joining() {

        List<Bill> bills = new BillRepertory().getDefault();

        String collect = bills.stream()
                .filter(b -> BillType.OVERDUE.equals(b.getBillType()))
                .map(Bill::getPeriods)
                .map(Object::toString)
                .collect(Collectors.joining(" ,"));

        System.out.println("periods : " + collect);
    }
}
