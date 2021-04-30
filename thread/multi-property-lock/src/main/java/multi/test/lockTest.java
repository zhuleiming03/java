package multi.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockTest {

    /**
     * 定义一个非公平的锁
     */
    private static Lock lock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {

        //线程0一直持有锁5000毫秒
        new Thread(() -> {
            System.out.println("线程[" + Thread.currentThread().getName() + "]尝试获取锁");
            lock.lock();
            try {
                System.out.println("线程[" + Thread.currentThread().getName() + "]获取了锁...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {//在finally代码块中是否锁
                lock.unlock();
                System.out.println("线程[" + Thread.currentThread().getName() + "]释放了锁..");
            }
        }).start();
        Thread.sleep(10);
        //线程1通过lock.lock()持续去尝试获取锁
        new Thread(() -> {
            System.out.println("线程[" + Thread.currentThread().getName() + "]通过lock.lock()持续去尝试获取锁");
            lock.lock();
            try {
                System.out.println("线程[" + Thread.currentThread().getName() + "]获取了锁...");
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {//在finally代码块中是否锁
                lock.unlock();
                System.out.println("线程[" + Thread.currentThread().getName() + "]释放了锁..");
            }
        }).start();
    }
}
