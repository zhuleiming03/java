import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class baseTest {

    @Test
    public void init() {
        System.out.println(new BigDecimal(10.115));
        System.out.println(new BigDecimal(10.115).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
    }

    @Test
    public void string() {
        BigDecimal source = new BigDecimal(10880000.112);
        System.out.println(source);
        System.out.println(source.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
        System.out.println(decimalFormat.format(source));

        System.out.println(new DecimalFormat("###,###.##").format(0.8));
        System.out.println(new DecimalFormat("###,###.00").format(0.8));
        System.out.println(new DecimalFormat("###,##0.00").format(0.8));
        System.out.println(new DecimalFormat("000,000.00").format(0.8));
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

    @Test
    public void compare() {
        BigDecimal op1 = new BigDecimal(10.56f);
        BigDecimal op2 = new BigDecimal(51.1f);
        System.out.printf("%s > %s : %s", op2, op1, op2.compareTo(op1) > 0);
    }
}
