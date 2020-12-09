package test.object;

import java.time.LocalTime;
import java.util.LinkedList;

/**
 * Thread.sleep(long)
 * 线程休眠指定时间
 */
public class WaitTest {

    public static void main(String[] args) {

        System.out.println(LocalTime.now() + " : 主线程开始");

        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < COUNT; i++) {
            try {
                System.out.println(LocalTime.now() + " : linkedList add " + i);
                linkedList.wait(100L);
            } catch (Exception e) {
                System.out.println(LocalTime.now() + " : 等待0.1秒");
            }
        }

        System.out.println(LocalTime.now() + " : 主线程结束");
    }

    private static final Integer COUNT = 4;
}
