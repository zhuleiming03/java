import org.junit.Test;
import pojo.Apple;
import service.FunctionService;

public class FunctionTest {

    @Test
    public void baseTest(){

        Apple apple=new Apple(10f,"red");

        System.out.println("101 是否能被3整除： " +
                FunctionService.test(apple, apple1 -> apple.getColor()));
    }

}
