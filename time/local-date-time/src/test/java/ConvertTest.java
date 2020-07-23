import org.junit.Test;

import java.time.LocalDateTime;

public class ConvertTest {

    @Test
    public void timeTest() {

        LocalDateTime localDateTime = LocalDateTime.of(1990, 5, 15, 12, 45, 21);

        System.out.println(localDateTime);
        System.out.println(localDateTime.toLocalDate());
        System.out.println(localDateTime.toLocalTime());
    }
}
