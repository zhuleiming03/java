package test.thread;

/**
 * thread.start()
 * 启动线程
 */
public class StartTest {

    public static void main(String[] args) {

        Thread instance = new Thread(() -> {
            Thread self = Thread.currentThread();
            System.out.println("----------------------------------");
            System.out.println("线程详情: " + self.toString());
            System.out.println("线程ID: " + self.getId());
        });

        // run 还在主线程中执行 就是普通的方法调用
        instance.run();

        // start 创建子线程 再执行
        instance.start();
    }
}
