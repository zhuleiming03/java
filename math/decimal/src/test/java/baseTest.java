import org.junit.Test;

import java.math.BigDecimal;

public class baseTest {

    @Test
    public void init() {
        System.out.println(new BigDecimal(10.11f));
    }

    @Test
    public void add() {
        BigDecimal op1 = new BigDecimal(10.56f);
        BigDecimal op2 = new BigDecimal(51.1f);
        System.out.printf("%s + %s = %s", op1, op2, op1.add(op2));
    }

    @Test
    public void subtract() {
        BigDecimal op1 = new BigDecimal(10.56f);
        BigDecimal op2 = new BigDecimal(51.1f);
        System.out.printf("%s - %s = %s", op1, op2, op1.subtract(op2));
    }

    @Test
    public void multiply() {
        BigDecimal op1 = new BigDecimal(10.56f);
        BigDecimal op2 = new BigDecimal(51.1f);
        System.out.printf("%s * %s = %s", op1, op2, op1.multiply(op2));
    }

    @Test
    public void divide() {
        BigDecimal op1 = new BigDecimal(10.56f);
        BigDecimal op2 = new BigDecimal(51.1f);
        System.out.printf("%s %% %s = %s", op1, op2, op1.divide(op2, 2));
    }
}
