import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConvertTest {

    @Test
    public void DateAndStringTest() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        System.out.println(formatter.format(new Date()));
    }

    @Test
    public void before() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date today = formatter.parse(formatter.format(new Date()));
        System.out.println(today);
        Date old = new Date(2020, 1, 20, 9, 37);
        System.out.println(old);
        System.out.println(today.before(old));
    }
}
