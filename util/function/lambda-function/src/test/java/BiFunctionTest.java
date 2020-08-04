import org.junit.Test;
import pojo.Apple;
import service.InvokingBiFunctionService;

/**
 * 接受两个输入参数的方法，并且返回一个结果
 */
public class BiFunctionTest {

    @Test
    public void applyTest() {

        Apple red = new Apple(15.4f, "red");
        Apple green = new Apple(19.5f, "green");

        System.out.println("Apple 合计重量：" +
                InvokingBiFunctionService.apply(red, green,
                        (a, b) -> a.getWeight() + b.getWeight()));
    }

    @Test
    public void andThenTest() {

        Apple red = new Apple(15.4f, "red");
        Apple green = new Apple(19.5f, "green");
        Float price = 5.4f;

        System.out.println("Apple 合计金额（单价5.4）：" +
                InvokingBiFunctionService.andThen(red, green,
                        (a, b) -> a.getWeight() + b.getWeight(),
                        v -> v * price));
    }
}
