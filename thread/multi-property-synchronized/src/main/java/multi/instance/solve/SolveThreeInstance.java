package multi.instance.solve;

import multi.test.SolveTest;

/**
 * 加锁对象是
 * 共享变量	SolveTest.GLOBAL_OBJECT
 */
public class SolveThreeInstance {

    private static final int COUNT = 10000;

    private int result = 0;

    public void increment() {
        synchronized (SolveTest.GLOBAL_OBJECT) {
            for (int i = 0; i < COUNT; i++) {
                result++;
            }
        }
    }

    public int getResult() {
        return result;
    }
}
