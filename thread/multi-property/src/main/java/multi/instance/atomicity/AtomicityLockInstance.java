package multi.instance.atomicity;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 通过Lock接口保证指定范围代码的原子性
 */
public class AtomicityLockInstance extends AtomicityIssueInstance {

    /**
     * 定义个读写锁：锁内运行多线程读，单线程写
     */
    private static final ReentrantReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock(true);

    @Override
    public void increment() {
        //写锁 加锁
        READ_WRITE_LOCK.writeLock().lock();
        try {
            //开始写
            super.increment();
        } finally {
            //将解锁放在finally块中，保证必然执行，防止死锁
            READ_WRITE_LOCK.writeLock().unlock();
        }
    }
}
