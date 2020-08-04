import org.junit.Test;
import service.InvokingCustomService;

/**
 * 自定义方法
 */
public class CustomTest {

    @Test
    public void baseTest() {

        System.out.println("合计： " +
                InvokingCustomService.test((a, b, c, d) -> a + b + c + d, 1, 2, 3, 4));
    }
}
