package multi.instance.solve;

/**
 * 加锁对象是
 * 类静态变量 STATIC_OBJECT
 */
public class SolveTwoInstance {

    private static final int COUNT = 10000;

    private int result = 0;

    private final static byte[] STATIC_OBJECT = new byte[0];

    public void increment() {
        synchronized (STATIC_OBJECT) {
            for (int i = 0; i < COUNT; i++) {
                result++;
            }
        }
    }

    public int getResult() {
        return result;
    }
}
