package test.thread;

/**
 * thread.getState()
 * 线程状态
 */
public class StateTest {

    public static void main(String[] args) {

        // NEW：             一个尚未启动的线程的状态。也称之为初始状态、开始状态。
        // RUNNABLE：        一个可以运行的线程的状态，可以运行是指这个线程已经在JVM中运行了，但是有可能正在等待其他的系统资源。也称之为就绪状态、可运行状态。
        // BLOCKED：         一个线程因为等待监视锁而被阻塞的状态。也称之为阻塞状态。
        // WAITING：         一个正在等待的线程的状态。也称之为等待状态。造成线程等待的原因有三种，分别是调用Object.wait()、join()以及LockSupport.park()方法。处于等待状态的线程，正在等待其他线程去执行一个特定的操作。例如：因为wait()而等待的线程正在等待另一个线程去调用notify()或notifyAll()；一个因为join()而等待的线程正在等待另一个线程结束。
        // TIMED_WAITING：   一个在限定时间内等待的线程的状态。也称之为限时等待状态。造成线程限时等待状态的原因有五种，分别是：Thread.sleep(long)、Object.wait(long)、join(long)、LockSupport.parkNanos(obj,long)和LockSupport.parkUntil(obj,long)。
        // TERMINATED：      一个完全运行完成的线程的状态。也称之为终止状态、结束状态。

        // 定义一个阻塞线程
        Thread blockInstance = new Thread(() -> {
            synchronized (COUNT) {
                try {
                    System.out.printf("[%5s] : %s \n", Thread.currentThread().getName(), Thread.currentThread().getState());
                    Thread.sleep(500);
                    COUNT.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        blockInstance.setName("block");
        System.out.printf("[%5s] : %s \n", blockInstance.getName(), blockInstance.getState());

        // 定义一个释放线程
        Thread notifyInstance = new Thread(() -> {
            synchronized (COUNT) {
                COUNT.notify();
            }
        });

        // 定义一个休眠线程
        Thread sleepInstance = new Thread(() -> {
            synchronized (COUNT) {
                delay(2000);
            }
        });
        sleepInstance.setName("sleep");

        // 启动子线程
        blockInstance.start();
        sleepInstance.start();

        // 100毫秒后查看休眠线程 休眠线程被阻塞
        delay(100);
        System.out.printf("[%5s] : %s \n", sleepInstance.getName(), sleepInstance.getState());

        // 1秒后查看阻塞线程 阻塞线程处于等待中
        delay(1000);
        System.out.printf("[%s] : %s \n", blockInstance.getName(), blockInstance.getState());

        // 释放锁
        notifyInstance.start();

        // 查看休眠线程 处于休眠中
        delay(500);
        System.out.printf("[%5s] : %s \n", sleepInstance.getName(), sleepInstance.getState());

        // 查看阻塞线程 已完全运行结束
        delay(2000);
        System.out.printf("[%5s] : %s \n", blockInstance.getName(), blockInstance.getState());
        System.out.printf("[%5s] : %s \n", sleepInstance.getName(), sleepInstance.getState());
    }

    private final static Integer COUNT = 0;

    private static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
