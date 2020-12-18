package test.thread;

/**
 * thread.getState()
 * 线程状态
 */
public class StateTest {

    public static void main(String[] args) {

        // NEW：             一个尚未启动的线程的状态。也称之为初始状态、开始状态。
        // RUNNABLE：        一个可以运行的线程的状态。可以运行是指这个线程可能已经在JVM中运行了，但是也可能正在等待其他的系统资源。也称之为就绪状态、可运行状态。
        // BLOCKED：         一个线程因为等待监视锁而被阻塞的状态。也称之为阻塞状态。
        // WAITING：         一个正在等待的线程的状态。也称之为等待状态。造成线程等待的原因有三种，分别是调用Object.wait()、join()以及LockSupport.park()方法。处于等待状态的线程，正在等待其他线程去执行一个特定的操作。例如：因为wait()而等待的线程正在等待另一个线程去调用notify()或notifyAll()；一个因为join()而等待的线程正在等待另一个线程结束。
        // TIMED_WAITING：   一个在限定时间内等待的线程的状态。也称之为限时等待状态。造成线程限时等待状态的原因有五种，分别是：Thread.sleep(long)、Object.wait(long)、join(long)、LockSupport.parkNanos(obj,long)和LockSupport.parkUntil(obj,long)。
        // TERMINATED：      一个完全运行完成的线程的状态。也称之为终止状态、结束状态。

        // 定义线程 one 运行1秒后进入等待状态
        Thread instanceOne = new Thread(() -> {
            synchronized (COUNT) {
                try {
                    System.out.printf("[%s] : ------ get lock ------- \n", Thread.currentThread().getName());
                    System.out.printf("[%s] : %s \n", Thread.currentThread().getName(), Thread.currentThread().getState());
                    Thread.sleep(1000);
                    System.out.printf("[%s] : ------ remove lock ---- \n", Thread.currentThread().getName());
                    COUNT.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        instanceOne.setName("one");
        System.out.printf("[%s] : %s \n", instanceOne.getName(), instanceOne.getState());

        // 定义线程 two 运行1秒后唤醒等待状态线程
        Thread instanceTwo = new Thread(() -> {
            synchronized (COUNT) {
                System.out.printf("[%s] : ------ get lock ------- \n", Thread.currentThread().getName());
                delay(1000);
                COUNT.notify();
                System.out.printf("[%s] : ------ remove lock ---- \n", Thread.currentThread().getName());
            }
        });
        instanceTwo.setName("two");
        System.out.printf("[%s] : %s \n", instanceTwo.getName(), instanceOne.getState());

        // 先启动线程 one 后再启动线程 two 保证 one 先运行
        instanceOne.start();
        delay(10);
        instanceTwo.start();

        // one 抢占锁先运行 two 被阻塞 状态由就绪变成阻塞
        System.out.printf("[%s] : %s ->", instanceTwo.getName(), instanceTwo.getState());
        delay(10);
        System.out.printf(" %s \n", instanceTwo.getState());

        // one 运行1秒后进入等待状态并释放锁
        delay(1000);
        System.out.printf("[%s] : %s \n", instanceOne.getName(), instanceOne.getState());

        // 获得锁后的 two 进入休眠状态
        System.out.printf("[%s] : %s \n", instanceTwo.getName(), instanceTwo.getState());

        // 1秒之后 two 结束休眠 并唤醒等待中的 one 两个线程都结束运行
        delay(1000);
        System.out.printf("[%s] : %s \n", instanceOne.getName(), instanceOne.getState());
        System.out.printf("[%s] : %s \n", instanceTwo.getName(), instanceTwo.getState());
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
