package multi.instance;

/**
 * 同步代码块
 * 加锁对象是本地变量的同步代码块
 */
public class BlockOrdinaryVariableInstance extends IssueInstance {

    private final byte[] ordinaryObj = new byte[0];

    @Override
    public void increment() {
        synchronized (ordinaryObj) {
            super.increment();
        }
    }
}
