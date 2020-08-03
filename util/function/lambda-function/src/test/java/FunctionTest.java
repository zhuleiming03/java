import org.junit.Test;
import pojo.Apple;
import pojo.ColorEnums;
import repertory.ApplyRepertory;
import service.InvokingFunctionService;

public class FunctionTest {

    @Test
    public void applyTest() {

        System.out.println("Apple 重量：" +
                InvokingFunctionService.apply(ApplyRepertory.getDefault(),
                        Apple::getWeight));
    }

    @Test
    public void composeTest() {

        System.out.println("Apple 颜色：" +
                InvokingFunctionService.compose(ApplyRepertory.getDefault(),
                        Apple::getColor, ColorEnums::getValueByKey));
    }

    @Test
    public void andThenTest() {

        System.out.println("Apple 颜色：" +
                InvokingFunctionService.andThen(ApplyRepertory.getDefault(),
                        Apple::getColor, ColorEnums::getValueByKey));
    }

}
