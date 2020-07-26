import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListTest {

    @Test
    public void baseTest(){
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = a1;
        List<Integer> a3 = new ArrayList<>();
        a1.addAll(a);
        a3.addAll(a);
        System.out.println("引用传递，是同一个list：" + (a1 == a2));
        System.out.println("两个引用，结果不等：" + (a1 == a3));

        Integer params = new Random().nextInt(100);
        List<Integer> b1 = getSafeList(a1, params);
        List<Integer> b2 = getUnSafeList(a1, params);
        System.out.println("新建实例，结果不等：" + (a1 == b1));
        System.out.println("引用传递，是同一个list：" + (a1 == b2));
    }

    private static <T> List<T> getSafeList(List<T> list, T t) {
        List<T> copyList = new ArrayList<>(list);
        copyList.add(t);
        return copyList;
    }

    private static <T> List<T> getUnSafeList(List<T> list, T t) {
        list.add(t);
        return list;
    }
}
