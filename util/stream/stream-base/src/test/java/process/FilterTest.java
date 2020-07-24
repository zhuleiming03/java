package process;

import org.junit.Test;
import repertory.BillRepertory;

public class FilterTest {

    @Test
    public void baseTest() {

        System.out.println("------------- filter ------------");

        new BillRepertory().getBills().stream()
                .filter(i -> PERIOD.equals(i.getPeriods()))
                .forEach(System.out::println);
    }

    private final static Integer PERIOD = 4;
}
