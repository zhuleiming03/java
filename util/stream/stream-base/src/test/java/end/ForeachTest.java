package end;

import org.junit.Test;
import repertory.BillRepertory;

public class ForeachTest {

    @Test
    public void baseTest() {

        System.out.println("------------- forEach ------------");

        new BillRepertory().getBills().stream()
                .forEach(System.out::println);

    }
}
