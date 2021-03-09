package multi.test;

import multi.common.ThreadService;
import multi.instance.FieldInstance;

import java.util.ArrayList;
import java.util.List;

public class FieldTest {


    /**
     * 作用域（代码块、方法）
     * 同步代码块比同步方法的锁住的范围更小，所以性能更好
     *
     * @param args
     */
    public static void main(String[] args) {

        FieldInstance instance = new FieldInstance();

        System.out.println("同步方法：指定方法处逐个执行");
        List<Thread> threads = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            Thread incrementThread = new Thread(() -> instance.method());
            threads.add(incrementThread);
        }
        ThreadService.threadPoolRun(threads);

        System.out.println("同步代码块：并行到指定功能处逐个执行");
        threads.clear();
        for (int i = 0; i < COUNT; i++) {
            Thread incrementThread = new Thread(() -> instance.block());
            threads.add(incrementThread);
        }
        ThreadService.threadPoolRun(threads);

    }

    private static final int COUNT = 3;

    public static int result = 0;
}
