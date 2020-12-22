import java.time.LocalTime;

/**
 * Thread 系列
 * thread-init
 * thread-pool
 * thread-method
 * thread-multi
 */
public class Instance {

    public static void main(String[] args) {
        test();
    }

    public static void test() {

        // 1 创建实例
        Thread son = new Thread(new InstanceThread());

        // 2 启动实例
        System.out.println(LocalTime.now() + " : 启动一个子线程");
        son.start();

        // 3 主线程同时工作
        for (int i = 0; i < COUNT; i++) {
            System.out.println("This is a parent thread :" + Thread.currentThread().getName());
            InstanceThread.delay();
        }
    }

    private static final Integer COUNT = 3;
}
