package process;

import org.junit.Test;
import pojo.Bill;
import repertory.BillRepertory;

import java.util.Comparator;

public class SortedTest {

    @Test
    public void baseTest() {

        System.out.println("------------- sorted ------------");

        new BillRepertory().getBills().stream()
                .sorted(Comparator.comparing(Bill::getPeriods))
                .forEach(System.out::println);
    }
}
