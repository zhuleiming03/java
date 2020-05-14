import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrderTest {

    public static void main(String[] args){

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "one");
        hashMap.put(3, "three");
        hashMap.put(2, "two");
        System.out.println("HashMap 是有序的，但不是按照插入先后顺序排序的");
        hashMap.forEach((k, v) -> System.out.printf("key:%s ,value: %s \n", k, v));

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "one");
        linkedHashMap.put(3, "three");
        linkedHashMap.put(2, "two");
        System.out.println("LinkedHashMap 是有序的，是按照插入先后顺序排序的");
        linkedHashMap.forEach((k, v) -> System.out.printf("key:%s ,value: %s \n", k, v));

        Map<Integer, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(1, "one");
        identityHashMap.put(3, "three");
        identityHashMap.put(1, "one one");
        identityHashMap.put(129, "test one");
        identityHashMap.put(129, "test two");
        System.out.println("IdentityHashMap 是有序的，可以插入重复key(不同的引用)");
        identityHashMap.forEach((k, v) -> System.out.printf("key:%s ,value: %s \n", k, v));
    }
}
