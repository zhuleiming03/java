package multi.instance;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class awaitTest {

    //定义一个非公平的锁
    private static Lock lock = new ReentrantLock(false);

    public static void main(String[] args) throws InterruptedException {

        Condition condition = lock.newCondition();
        //线程0：通过await()进行等待，直到被中断或者被唤醒
        Thread thread0 = new Thread(() -> {
            System.out.println("线程[await()-" + Thread.currentThread().getName() + "]尝试获取锁...");
            lock.lock();
            System.out.println("线程[await()-" + Thread.currentThread().getName() + "]获取了锁.");
            try {
                //通过await()进行等待，直到被中断或者被唤醒
                condition.await();
                System.out.println("线程[await()-" + Thread.currentThread().getName() + "]被唤醒...");
            } catch (InterruptedException e) {
                //e.printStackTrace();
                System.out.println("线程[await()-" + Thread.currentThread().getName() + "]被中断...");
            } finally {
                lock.unlock();
                System.out.println("线程[await()-" + Thread.currentThread().getName() + "]释放了锁.");
            }
        });

        thread0.start();


    }
}
