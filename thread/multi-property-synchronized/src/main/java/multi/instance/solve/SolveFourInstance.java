package multi.instance.solve;

/**
 * 加锁对象是
 * 实例对象 this 或 直接定义在非静态方法上
 */
public class SolveFourInstance {

    private static final int COUNT = 10000;

    private int result = 0;

    public synchronized void increment() {
        // 等价于 synchronized (this)
        for (int i = 0; i < COUNT; i++) {
            result++;
        }
    }

    public int getResult() {
        return result;
    }
}
