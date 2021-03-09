package multi.instance.solve;

/**
 * 加锁对象是
 * 类 SolveFiveInstance.class 或 直接定义在静态方法上
 */
public class SolveFiveInstance {

    private static final int COUNT = 10000;

    private static int result = 0;

    public synchronized static void increment() {
        // 等价于 synchronized (SolveFiveInstance.class) {
        for (int i = 0; i < COUNT; i++) {
            result++;
        }
    }

    public static int getResult() {
        return result;
    }
}
