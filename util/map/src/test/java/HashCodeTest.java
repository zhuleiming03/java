import org.junit.Test;
import pojo.Bill;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashCodeTest {

    @Test
    public void hashMapTest(){

        Bill one = new Bill(11);
        Bill two = new Bill(22);

        Map<Bill, Integer> map = new HashMap<>();
        map.put(null, null);
        map.put(one, one.getId());
        map.put(two, two.getId());

        System.out.println("--- HashMap 存在 key.hashcode 值相同的场景 ---");
        map.forEach((k, v) -> {
            String msg = "";
            if (k != null) {
                msg = String.format("key: %10s , value: %4s , key hashCode: %4d ",
                        k, v, k.hashCode());
            } else {
                msg = String.format("key: %10s , value: %4s", k, v);
            }
            System.out.println(msg);
        });
    }

    @Test
    public void concurrentHashMapTest(){

        Bill one = new Bill(11);
        Bill two = new Bill(22);

        Map<Bill, Integer> map = new ConcurrentHashMap<>();
        map.put(one, one.getId());
        map.put(two, two.getId());

        System.out.println("--- ConcurrentHashMap 存在 key.hashcode 值相同的场景 ---");
        map.forEach((k, v) -> {
            String msg = "";
            msg = String.format("key: %10s , value: %4s , key hashCode: %4d ",
                    k, v, k.hashCode());
            System.out.println(msg);
        });
    }
}
