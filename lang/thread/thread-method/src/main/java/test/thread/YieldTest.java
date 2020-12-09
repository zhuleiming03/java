package test.thread;

/**
 * thread.yield()
 * 使得当前线程退让出CPU资源，把CPU调度机会分配给同样线程优先级的线程。
 */
public class YieldTest {

    public static void main(String[] args) {

        // 创建线程实例，当i 能被10整除时，做出一次礼让操作
        Thread one = new Thread(() -> {
            for (int i = 0; i <= COUNT; i++) {
                if (i % 10 == 0) {
                    // 每当 i 能被 10 整除时 释放锁 重新竞争 CPU
                    System.out.println(String.format("[one] %2s", i));
                    Thread.yield();
                }
            }
        });
        Thread two = new Thread(() -> {
            for (int i = 0; i <= COUNT; i++) {
                if (i % 10 == 0) {
                    // 每当 i 能被 10 整除时 释放锁 重新竞争 CPU
                    System.out.println(String.format("[two] %6s", i));
                    Thread.yield();
                }
            }
        });
        Thread six = new Thread(() -> {
            for (int i = 0; i <= COUNT; i++) {
                if (i % 10 == 0) {
                    // 每当 i 能被 10 整除时 释放锁 重新竞争 CPU
                    System.out.println(String.format("[six] %9s", i));
                    Thread.yield();
                }
            }
        });

        six.start();
        one.start();
        two.start();
    }

    private static final Integer COUNT = 49;
}
