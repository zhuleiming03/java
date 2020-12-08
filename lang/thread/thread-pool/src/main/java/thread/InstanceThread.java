package thread;

import java.time.LocalDateTime;

public class InstanceThread implements Runnable {
    @Override
    public void run() {
        System.out.println(String.format("%s [%s] 正在被执行",
                LocalDateTime.now(), Thread.currentThread().getName()));
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
