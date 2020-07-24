package process;

import org.junit.Test;
import pojo.BillType;
import repertory.BillRepertory;

public class PeekTest {

    @Test
    public void baseTest() {

        System.out.println("------------- peek ------------");

        new BillRepertory().getBills().stream()
                .peek(System.out::println)
                .anyMatch(b -> BillType.OVERDUE.equals(b.getBillType()));
    }
}
