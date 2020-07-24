package process;

import org.junit.Test;
import repertory.BillRepertory;

public class SkipTest {

    @Test
    public void baseTest() {

        System.out.println("------------- skip ------------");

        new BillRepertory().getBills().stream()
                .skip(8)
                .forEach(System.out::println);
    }
}
