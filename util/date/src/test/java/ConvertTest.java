import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertTest {

    @Test
    public void DateAndStringTest() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        System.out.println(formatter.format(new Date()));
    }
}
