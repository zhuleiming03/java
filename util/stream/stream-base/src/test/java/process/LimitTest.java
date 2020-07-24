package process;

import org.junit.Test;
import repertory.BillRepertory;


public class LimitTest {

    @Test
    public void baseTest() {

        System.out.println("------------- limit ------------");

        new BillRepertory().getBills().stream()
                .limit(4)
                .forEach(System.out::println);
    }
}
