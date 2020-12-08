package test.thread;

/**
 * Thread.currentThread()
 * 获取当前正在运行的线程
 * <p>
 * thread.isAlive()
 * 判断线程是否还存活着
 */
public class ActiveCountTest {

    public static void main(String[] args) {

        // 定义三个线程
        Thread one = new Thread(new Instance());
        Thread two = new Thread(new Instance());
        Thread three = new Thread(new Instance());

        // 当前程序活着的线程数:2,一个是main线程，一个是GC线程
        System.out.println("当前正在运行的线程数量：" + Thread.activeCount());

        // 启动线程
        one.start();
        two.start();
        three.start();

        System.out.println("线程 one 是否还存活着：" + one.isAlive());
        System.out.println("当前正在运行的线程数量：" + Thread.activeCount());

    }

    public static class Instance implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(2L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
