import org.junit.Test;
import service.PredicateService;


public class PredicateTest {

    @Test
    public void baseTest(){

        System.out.println("101 是否能被3整除： " +
                PredicateService.test(101, i -> i % 3 == 0));
    }


}
