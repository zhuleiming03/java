import org.junit.Test;
import service.InvokingCustomService;
import service.PredicateService;

public class CustomTest {

    @Test
    public void baseTest() {

        System.out.println(" " +
                InvokingCustomService.test((a, b, c, d) -> a + b + c + d, 1, 2, 3, 4));
    }
}
