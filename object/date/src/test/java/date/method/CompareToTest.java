package date.method;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

public class CompareToTest {

    @Test
    public void beforeTest() {

        Date dateOne = new Date(2020, 1, 20, 9, 37);
        Date dateTwo = new Date(2019, 2, 1, 10, 37);
        System.out.printf("【%s】 is before 【%s】 result: %s \n", dateOne, dateTwo, dateOne.before(dateTwo));

        LocalDate localDateOne = LocalDate.of(2019, 1, 15);
        LocalDate localDateTwo = LocalDate.of(2022, 11, 15);
        System.out.printf("【%s】 is before 【%s】 result: %s \n", localDateOne, localDateTwo, localDateOne.isBefore(localDateTwo));
    }
}
