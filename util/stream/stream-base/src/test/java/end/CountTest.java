package end;

import org.junit.Test;
import repertory.BillRepertory;

public class CountTest {

    @Test
    public void baseTest() {

        System.out.println("------------- count ------------");

        long count = new BillRepertory().getBills().stream().count();

        System.out.println("账单数量：" + count);
    }
}
