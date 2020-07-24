package end;

import org.junit.Test;
import repertory.BillRepertory;

import java.math.BigDecimal;

public class AllMatchTest {

    @Test
    public void baseTest() {

        System.out.println("------------- allMatch ------------");

        BigDecimal amount = new BigDecimal(AMOUNT);

        boolean match = new BillRepertory().getBills().stream()
                .allMatch(b -> amount.compareTo(b.getAmount()) < 0);

        if (match) {
            System.out.println("所有账单金额都大于100");
        } else {
            System.out.println("存在账单金额都小于等于100");
        }

    }

    private final static Float AMOUNT = 100f;
}
