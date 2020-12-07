import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void joiningTest() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(3, "one");
        hashMap.put(2, "two");

        System.out.println(hashMap.values().stream().distinct().collect(Collectors.joining(";")));

    }

    @Test
    public void flatMapTest() {
        Map<Integer, List<String>> haspMap = new HashMap<>();
        haspMap.put(1, Arrays.asList("1", "one"));
        haspMap.put(2, Collections.singletonList("two"));
        haspMap.put(3, Arrays.asList("No.3", "three"));

        haspMap.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }
}
