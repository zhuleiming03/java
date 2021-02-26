package multi.instance.atomicity;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过Atomic类型保证类型的原子性
 */
public class AtomicityAtomicInstance extends AtomicityIssueInstance {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void increment() {
        for (int i = 0; i < COUNT; i++) {
            count.getAndIncrement();
        }
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
