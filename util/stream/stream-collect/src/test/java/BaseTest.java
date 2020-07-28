import org.junit.Test;
import pojo.Bill;
import repertory.BillRepertory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BaseTest {

    /**
     * collect 需要实现三个方法
     * 1、初始化容器
     * 2、对象累计处理
     * 3、对象组合累计处理
     */
    @Test
    public void concat() {

        List<String> strings = Arrays.asList("Hello", "World", "...");

        String one = strings.stream()
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
        System.out.println(one);

        String two = strings.stream()
                .collect(() -> new StringBuilder(),
                        (x, y) -> x.append(y),
                        (r1, r2) -> r1.append(r2))
                .toString();
        System.out.println(two);

        List<Bill> bills = new BillRepertory().getDefault();
        List<BigDecimal> three = bills.stream()
                .map(Bill::getAmount)
                .collect(LinkedList::new, List::add, List::addAll);
        System.out.println(three);
    }
}
