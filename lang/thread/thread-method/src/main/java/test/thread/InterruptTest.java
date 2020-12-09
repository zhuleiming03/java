package test.thread;

/**
 * interrupt()
 * 中断线程
 */
public class InterruptTest {

    public static void main(String[] args) {

        // 在不包括NIO场景下，interrupt()方法并不是中断线程，而是中断阻塞状态，或者将线程的[中断标志位]置为true

        // 对于未阻塞的线程，interrupt()只是造成[中断标志位]=rue，线程本身运行状态不受影响。
        //exampleOne();

        // 对于阻塞的线程，interrupt()会中断阻塞状态，使其转换成非阻塞状态，并抛出中断异常。
        //exampleTwo();

        // 建议写法
        // 阻塞场景
        exampleThree(true);
        // 非阻塞场景
        exampleThree(false);
    }

    private final static Integer COUNT = 6;

    /**
     * 中断未阻塞的线程
     */
    private static void exampleOne() {

        // interrupt() 并不能中断线程
        // interrupt() 中断线程的阻塞(sleep/join/wait)状态，或将 中断标志位 置为 true
        // 所以如果是普通的运行中的线程，流程并不会受到影响
        new Thread(() -> {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < COUNT; i++) {
                System.out.println(String.format("线程【%s】 正在运行第 %s 次 isInterrupted=%s",
                        Thread.currentThread().getName(), i, Thread.currentThread().isInterrupted()));
                if (i == 3) {
                    thread.interrupt();
                    System.out.println(String.format("线程【%s】 执行中断操作    isInterrupted=%s",
                            Thread.currentThread().getName(), Thread.currentThread().isInterrupted()));
                }
            }
            System.out.println(String.format("线程【%s】 结束运行        isInterrupted=%s",
                    Thread.currentThread().getName(), Thread.currentThread().isInterrupted()));
        }).start();
    }

    /**
     * 中断阻塞的线程
     */
    private static void exampleTwo() {

        // 造成阻塞状态的情况有：sleep()、wait()和join()。
        // 阻塞状态的线程被中断时，只是中断了阻塞状态，即sleep()、wait()和join()，
        // 会产生一个InterruptedException异常
        // 而中断标志位则不是那么准确了 true or false ?

        // 创建并执行子线程
        Thread son = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(String.format("线程【%s】 正在运行  isInterrupted=%s",
                            Thread.currentThread().getName(), Thread.currentThread().isInterrupted()));
                    Thread.sleep(1000L);
                }
            } catch (InterruptedException e) {
                // 中断处理
                System.out.println(String.format("线程【%s】 catch中断 isInterrupted=%s",
                        Thread.currentThread().getName(), Thread.currentThread().isInterrupted()));
            }
        });
        son.start();

        // 主进程休眠1秒
        try {
            Thread.sleep(4000L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 子线程中断
        son.interrupt();
        System.out.println(String.format("线程【%s】 中断停止  isInterrupted=%s",
                son.getName(), son.isInterrupted()));
    }

    /**
     * 建议写法
     *
     * @param block
     */
    private static void exampleThree(boolean block) {

        // 创建并执行子线程
        Thread son = new Thread(() -> {
            try {
                int i = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    // 执行业务逻辑 begin
                    i++;
                    if (block) {
                        Thread.sleep(300L);
                    } else {
                        if (i == 4) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(String.format("线程【%s】 运行%s 次 isInterrupted=%s",
                            Thread.currentThread().getName(), i, Thread.currentThread().isInterrupted()));
                    // 执行业务逻辑 end
                }
            } catch (Exception e) {
                System.out.println(String.format("线程【%s】 中断处理 isInterrupted=%s \n",
                        Thread.currentThread().getName(), Thread.currentThread().isInterrupted()));
            }
        });
        son.start();

        // 主进程休眠等待
        try {
            Thread.sleep(1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 子线程中断
        son.interrupt();
    }
}
