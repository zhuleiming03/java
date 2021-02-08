package decimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalTest {

    @Test
    public void init() {
        System.out.println(new BigDecimal(10.115));
    }

    @Test
    public void convertTest() {

        BigDecimal source = new BigDecimal(10880000.112);

        System.out.println("普通：                  " + source);
        System.out.println("四舍五入保留两位小数：  " +
                new BigDecimal(10.115).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());
        System.out.println("位数过多变成科学计数法：" +
                source.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue());

        // String
        System.out.println("\n--------------- 通过 # 和 0 格式化 (# 占位 0 补零)----------------");
        DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
        System.out.println(decimalFormat.format(source));
        System.out.println(new DecimalFormat("###,###.##").format(0.8));
        System.out.println(new DecimalFormat("###,###.00").format(0.8));
        System.out.println(new DecimalFormat("###,##0.00").format(0.8));
        System.out.println(new DecimalFormat("000,000.00").format(0.8));
    }
}
