import org.junit.Test;
import pojo.User;

import java.util.Collections;
import java.util.List;

public class ListTest {

    @Test
    public void baseTest() {
        User user = new User();

        List<User> users = Collections.singletonList(user);
        System.out.println(users);
    }
}
