package multi.instance;

import multi.test.LockTypeTest;

/**
 * 对象锁（非静态变量或方法）
 */
public class ObjectLockInstance extends BaseInstance {

    @Override
    public synchronized void increment() {
        for (int i = 0; i < COUNT; i++) {
            LockTypeTest.result++;
        }
    }
}
