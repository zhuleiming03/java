package multi.common;

import java.util.List;

public class ThreadService {

    public static void threadPoolRun(List<Thread> threads) {

        // 启动线程组
        threads.forEach(Thread::start);

        // 等待线程结束
        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
