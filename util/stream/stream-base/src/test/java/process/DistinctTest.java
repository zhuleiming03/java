package process;

import org.junit.Test;
import pojo.Bill;
import repertory.BillRepertory;


public class DistinctTest {

    @Test
    public void baseTest() {

        System.out.println("------------- distinct ------------");

        new BillRepertory().getBills().stream()
                .map(Bill::getBillType)
                .distinct()
                .forEach(System.out::println);
    }
}
