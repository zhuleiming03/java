import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PairTest {

    @Test
    public void baseTest() {

        Map<Integer, String> map = new HashMap<>(COUNT);

        for (int i = 0; i < COUNT; i++) {
            Pair<Integer, String> pair = getPair(i);
            map.put(pair.getKey(), pair.getValue());
        }

        map.forEach((k, v) -> System.out.println(v));
    }

    private static final int COUNT = 12;

    private Pair<Integer, String> getPair(Integer i) {
        return new Pair<>(i, String.format("example: %2d", i));
    }
}
