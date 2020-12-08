package test.thread;

/**
 * thread.getThreadGroup()
 * 获取线程所在线程组。
 */
public class ThreadGroupTest {

    public static void main(String[] args) {

        // 关于线程的字符串描述 Thread[Thread-0,5,main]，三个值分别代表：线程名、优先级和线程组名。
        Thread instance = new Thread(() -> {
            System.out.println("当前线程：" + Thread.currentThread());
            System.out.println("当前线程-名字：" + Thread.currentThread().getName());
            System.out.println("当前线程-优先级：" + Thread.currentThread().getPriority());
            System.out.println("当前线程-线程组名字：" + Thread.currentThread().getThreadGroup().getName() + "\n");
        });

        instance.start();
    }
}
