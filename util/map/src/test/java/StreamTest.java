import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void baseTest() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(3, "one");
        hashMap.put(2, "two");

        System.out.println(hashMap.values().stream().distinct().collect(Collectors.joining(";")));

    }
}
