package multi.test;

import multi.instance.BlockOrdinaryVariableInstance;

import java.util.ArrayList;
import java.util.List;

public class BlockOrdinaryVariableTest {

    public static void main(String[] args) {

        BlockOrdinaryVariableInstance blockOrdinaryVariableInstance = new BlockOrdinaryVariableInstance();

        System.out.println("100个线程自增10000次,理论结果：        1000000");
        System.out.println("初始值：" + blockOrdinaryVariableInstance.getCount());

        // 初始化线程组
        List<Thread> threads = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            if (i % 2 == 0) {
                Thread incrementThread = new Thread(() -> new BlockOrdinaryVariableInstance().increment());
                threads.add(incrementThread);
                incrementThread.start();
            } else {
                Thread incrementThread = new Thread(() -> blockOrdinaryVariableInstance.increment());
                threads.add(incrementThread);
                incrementThread.start();
            }
        }

        // 等待线程结束
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("未做任何限制的自增逻辑并发时实际结果： " + blockOrdinaryVariableInstance.getCount());
    }

    private static final int COUNT = 100;
}
