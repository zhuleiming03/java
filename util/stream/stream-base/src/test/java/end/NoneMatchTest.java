package end;

import org.junit.Test;
import repertory.BillRepertory;

public class NoneMatchTest {

    @Test
    public void baseTest() {

        System.out.println("------------- noneMatch ------------");

        boolean match = new BillRepertory().getBills().stream()
                .noneMatch(b -> b.getPeriods() > 13);

        if (match) {
            System.out.println("不存在期数超过13的账单");
        }
    }
}
