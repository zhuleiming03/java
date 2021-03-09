package multi.instance.solve;

/**
 * 加锁对象是
 * 本地变量 localObject
 */
public class SolveOneInstance {

    private static final int COUNT = 10000;

    private int result = 0;

    private final byte[] localObject = new byte[0];

    public void increment() {
        synchronized (localObject) {
            for (int i = 0; i < COUNT; i++) {
                result++;
            }
        }
    }

    public int getResult() {
        return result;
    }
}
