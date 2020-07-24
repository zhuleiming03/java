package end;

import org.junit.Test;
import pojo.Bill;
import repertory.BillRepertory;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReduceTest {

    @Test
    public void baseTest() {

        System.out.println("------------- reduce ------------");

        BigDecimal reduce = new BillRepertory().getBills().stream()
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("账单合计金额：" + reduce);
    }


    @Test
    public void integerTest(){

        System.out.println("------------- reduce(终端) ------------");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Integer add = numbers.stream().reduce(6, (x, y) -> x + y);
        System.out.println("数组之和是：" + add);

        int addNum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("数组之和(非拆箱写法)是：" + addNum);

        Integer mult = numbers.stream().reduce(1, (x, y) -> x * y);
        System.out.println("数组之积是：" + mult);

        numbers.stream().reduce(Integer::min)
                .ifPresent(n -> System.out.println("数组最小值是：" + n));

        numbers.stream().reduce(Integer::max)
                .ifPresent(n -> System.out.println("数组最大值是：" + n));
    }
}
