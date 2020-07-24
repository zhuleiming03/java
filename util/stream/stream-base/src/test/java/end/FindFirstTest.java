package end;

import org.junit.Test;
import repertory.BillRepertory;


public class FindFirstTest {

    @Test
    public void baseTest() {

        System.out.println("------------- findFirst ------------");

        // 获取第一个元素
        new BillRepertory().getBills().stream()
                .findFirst()
                .ifPresent(System.out::println);
    }
}
