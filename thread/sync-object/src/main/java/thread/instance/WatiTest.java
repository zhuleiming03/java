package thread.instance;

public class WatiTest {

    private final static Integer COUNT = 0;

    public static void main(String[] args) {

        // 定义线程 one 运行1秒后进入等待状态
        Thread instanceOne = new Thread(() -> {
            synchronized (COUNT) {
                try {
                    System.out.printf("[%s] : ------ get lock ------- \n", Thread.currentThread().getName());
                    System.out.printf("[%s] : %s \n", Thread.currentThread().getName(), Thread.currentThread().getState());
                    System.out.printf("[%s] : ------ remove lock ---- \n", Thread.currentThread().getName());
                    COUNT.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        instanceOne.start();

        // 定义线程 two 运行1秒后唤醒等待状态线程
        Thread instanceTwo = new Thread(() -> {
            synchronized (COUNT) {
                System.out.printf("[%s] : ------ get lock ------- \n", Thread.currentThread().getName());
                delay(1000);
                COUNT.notify();
                System.out.printf("[%s] : ------ remove lock ---- \n", Thread.currentThread().getName());
            }
        });

        delay(1000);
        Thread instanceThree = new Thread(() -> {
            synchronized (COUNT) {
                try {
                    System.out.printf("[%s] : ------ get lock ------- \n", Thread.currentThread().getName());
                    System.out.printf("[%s] : %s \n", Thread.currentThread().getName(), Thread.currentThread().getState());
                    System.out.printf("[%s] : ------ remove lock ---- \n", Thread.currentThread().getName());
                    COUNT.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        instanceThree.start();

        delay(1000);
        System.out.println(instanceOne.getState());

    }

    private static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
