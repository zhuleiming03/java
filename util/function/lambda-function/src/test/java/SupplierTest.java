import org.junit.Test;
import pojo.Apple;
import service.InvokingSupplierService;

/**
 * 无参数，返回一个结果。
 */
public class SupplierTest {

    @Test
    public void getTest() {

        System.out.println(InvokingSupplierService.get(() -> new Apple(15.5f, "rea")));
    }

}
