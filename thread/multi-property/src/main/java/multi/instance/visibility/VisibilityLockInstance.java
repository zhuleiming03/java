package multi.instance.visibility;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过Lock接口保障可见性
 */
public class VisibilityLockInstance extends VisibilityIssueInstance {

    private ReentrantLock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    @Override
    public void shutdown() {
        lock.lock();
        try {
            super.shutdown();
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        System.out.printf("Thread [%s] running...    flag【%s】 \n", Thread.currentThread().getName(), shutdown);
        lock.lock();
        try {
            condition.await();
            super.running();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.printf("Thread [%s] stop! \n", Thread.currentThread().getName());
    }
}
