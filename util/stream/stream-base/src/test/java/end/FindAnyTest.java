package end;

import org.junit.Test;
import repertory.BillRepertory;

public class FindAnyTest {

    @Test
    public void baseTest() {

        System.out.println("------------- findAny ------------");

        // 获取任意一个满足要求的元素
        new BillRepertory().getBills().stream()
                .findAny()
                .ifPresent(System.out::println);
    }
}
