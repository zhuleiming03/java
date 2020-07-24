package process;

import org.junit.Test;
import pojo.BillType;
import repertory.BillRepertory;

public class PeekTest {

    @Test
    public void baseTest() {

        System.out.println("------------- peek ------------");

        new BillRepertory().getBills().stream()
                .peek(b -> b.setPeriods(b.getPeriods() * 10))
                .forEach(System.out::println);
    }
}
