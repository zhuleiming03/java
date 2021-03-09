package multi.instance;

import multi.test.LockTypeTest;

/**
 * 类锁（静态变量或方法）
 */
public class ClassLockInstance extends BaseInstance {

    @Override
    public void increment() {
        synchronized (ClassLockInstance.class) {
            for (int i = 0; i < COUNT; i++) {
                LockTypeTest.result++;
            }
        }
    }
}
