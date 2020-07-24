package end;

import org.junit.Test;
import pojo.BillType;
import repertory.BillRepertory;

public class AnyMatchTest {

    @Test
    public void baseTest() {

        System.out.println("------------- anyMatch ------------");

        boolean match = new BillRepertory().getBills().stream()
                .anyMatch(b -> BillType.OVERDUE.equals(b.getBillType()));

        if (match) {
            System.out.println("至少存在一条逾期账单");
        }

    }
}
