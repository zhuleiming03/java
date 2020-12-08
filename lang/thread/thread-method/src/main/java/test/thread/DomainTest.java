package test.thread;

/**
 * thread.isDaemon()
 * 判断线程是否是守护线程。
 * <p>
 * thread.setDaemon(true)
 * 将指定线程设置为守护线程。
 */
public class DomainTest {

    /**
     * 所谓[守护线程],可以理解为后台线程或非用户线程。
     * 当前程序中，只剩下main线程和守护线程，且main线程执行完毕时，系统结束。
     *
     * @param args
     */
    public static void main(String[] args) {

        // 定义用户线程
        Thread normalThread = new Thread(() -> {
            delay(1000L);
            System.out.println("normalThread线程正在工作...");
        });

        // 定义守护线程
        Thread daemonThread = new Thread(() -> {
            delay(1000L);
            System.out.println("daemonThread线程正在工作...");
        });
        daemonThread.setDaemon(true);

        // 启动线程
        normalThread.start();
        daemonThread.start();
        System.out.println("通过thread.isDaemon()判断当前线程[normalThread]是否是守护线程：" + normalThread.isDaemon());
        System.out.println("通过thread.isDaemon()判断当前线程[daemonThread]是否是守护线程：" + daemonThread.isDaemon());

        System.out.println("终止线程[normalThread]");
        normalThread.stop();

        // 等待线程死掉
        delay(2000);
        System.out.println("normalThread是否存活：" + normalThread.isAlive());
        System.out.println("daemonThread是否存活：" + daemonThread.isAlive());
    }

    private static void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
