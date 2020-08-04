import org.junit.Test;
import pojo.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CapacityTest {

    private final static int MAX_COUNT = 10000;

    @Test
    public void bastTest() {

        List<Integer> idsList = new LinkedList<>();
        List<User> userList = new LinkedList<>();
        List<String> userNameList = new LinkedList<>();
        Map<Integer, Integer> idsMap = new HashMap<>();
        Map<Integer, User> userMap = new HashMap<>();
        Map<Integer, String> userNameMap = new HashMap<>();

        //初始化数据
        for (int i = 0; i < MAX_COUNT; i++) {
            if (i % 2 == 0) {
                idsList.add(i);
                idsMap.put(i, i);
            }
            if (i % 3 == 0) {
                User po = new User();
                po.setUserId(i);
                po.setUserName("漩涡鸣人影分身->" + i);
                userList.add(po);
                userMap.put(i, po);
            }
        }
        System.out.println("ids list count:" + idsList.size());
        System.out.println("user List count:" + userList.size());
        System.out.println("ids map count:" + idsMap.size());
        System.out.println("user Map count:" + userMap.size());


        long start = System.nanoTime();
        for (Integer id : idsList) {
            for (User po : userList) {
                if (id.equals(po.getUserId())) {
                    userNameList.add(po.getUserName());
                }
            }
        }
        long duration = (System.nanoTime() - start) / 1_000_000;

        System.out.println(String.format("userNameList count:%d,耗时：%s 毫秒",
                userNameList.size(), duration));

        start = System.nanoTime();
        for (Integer id : idsMap.keySet()) {
            for (Map.Entry<Integer, User> po : userMap.entrySet()) {
                if (id.equals(po.getKey())) {
                    userNameMap.put(id, po.getValue().getUserName());
                }
            }
        }
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(String.format("userNameMap count:%d,耗时：%s 毫秒",
                userNameMap.size(), duration));
    }
}
