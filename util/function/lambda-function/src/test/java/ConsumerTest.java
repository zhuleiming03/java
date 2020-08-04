import org.junit.Test;
import repertory.ApplyRepertory;
import service.InvokingConsumerService;

/**
 * 接受一个输入参数并且无返回的操作
 */
public class ConsumerTest {

    @Test
    public void applyTest() {

        InvokingConsumerService.accept(ApplyRepertory.getDefault(),
                System.out::println);
    }

    @Test
    public void andThenTest() {

        InvokingConsumerService.andThen(ApplyRepertory.getDefault(),
                a -> a.setColor("green"), System.out::println);
    }
}
