package decimal.method;

import org.junit.Test;

import java.math.BigDecimal;

public class MathTest {

    @Test
    public void add() {
        BigDecimal op1 = new BigDecimal(10.56);
        BigDecimal op2 = new BigDecimal(51.1);
        System.out.printf("%s + %s = %s", op1, op2, op1.add(op2));
    }

    @Test
    public void subtract() {
        BigDecimal op1 = new BigDecimal(10.56);
        BigDecimal op2 = new BigDecimal(51.1);
        System.out.printf("%s - %s = %s", op1, op2, op1.subtract(op2));
    }

    @Test
    public void multiply() {
        BigDecimal op1 = new BigDecimal(10.56);
        BigDecimal op2 = new BigDecimal(51.1);
        System.out.printf("%s * %s = %s", op1, op2, op1.multiply(op2));
    }

    @Test
    public void divide() {
        BigDecimal op1 = new BigDecimal(10.56);
        BigDecimal op2 = new BigDecimal(51.1);
        System.out.printf("%s %% %s = %s", op1, op2, op1.divide(op2, 2));
    }
}
