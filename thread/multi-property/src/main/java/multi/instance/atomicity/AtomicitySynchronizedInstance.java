package multi.instance.atomicity;

/**
 * 通过synchronized保证代码块的原子性
 */
public class AtomicitySynchronizedInstance extends AtomicityIssueInstance {

    @Override
    public synchronized void increment() {
        super.increment();
    }
}
