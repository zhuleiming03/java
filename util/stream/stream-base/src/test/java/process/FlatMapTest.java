package process;

import org.junit.Test;
import pojo.Bill;
import repertory.BillRepertory;

import java.util.Arrays;

public class FlatMapTest {

    @Test
    public void baseTest() {

        System.out.println("------------- flatMap ------------");

        new BillRepertory().getBills().stream()
                .map(Bill::getBillType)
                .map(Enum::toString)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(l -> System.out.printf("%s ", l));
    }
}
