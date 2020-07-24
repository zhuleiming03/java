package process;

import org.junit.Test;
import pojo.Bill;
import repertory.BillRepertory;

public class MapTest {

    @Test
    public void baseTest() {

        System.out.println("------------- map ------------");

        new BillRepertory().getBills().stream()
                .map(Bill::getDueDate)
                .forEach(System.out::println);
    }
}
