package decimal.method;

import org.junit.Test;

import java.math.BigDecimal;

public class CompareToTest {

    @Test
    public void compareToTest() {
        BigDecimal op1 = new BigDecimal(10.56);
        BigDecimal op2 = new BigDecimal(51.1);
        BigDecimal op3 = new BigDecimal(95.65);
        System.out.printf("%s > %s : %s \n", op2, op1, op2.compareTo(op1));
        System.out.printf("%s = %s : %s \n", op2, op2, op2.compareTo(op2));
        System.out.printf("%s < %s : %s \n", op2, op3, op2.compareTo(op3));
    }
}
