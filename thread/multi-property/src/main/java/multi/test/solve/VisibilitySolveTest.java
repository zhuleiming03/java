package multi.test.solve;

import multi.common.ThreadService;
import multi.instance.visibility.*;

/**
 * 并发可见性测试
 * 可见性：当一个线程修改了共享变量的值，其他线程能够看到修改的值。
 * 在多线程场景下，由于指令重排会导致并发共享变量的值不可见
 * 指令重排：CPU 执行单元的速度要远超主存访问速度。在执行程序时，为了提高性能，编译器和处理器会对指令做重排序。
 */
public class VisibilitySolveTest {

    /**
     * volatile 关键字
     * synchronized 关键字
     * Lock 接口
     * Atomic 变量
     *
     * @param args
     */
    public static void main(String[] args) {

        // 通过volatile关键字标记内存屏障保证可见性。
        volatileTest(new VisibilityVolatileInstance());

        // 通过synchronized关键字定义同步代码块或者同步方法保障可见性。
        synchronizedTest(new VisibilitySynchronizedInstance());

        // 通过Lock接口保障可见性。
        lockTest(new VisibilityLockInstance());

        // 通过Atomic类型保障可见性。
        atomicTest(new VisibilityAtomicInstance());

    }

    private static void volatileTest(VisibilityVolatileInstance visibilityVolatileInstance) {

        System.out.println("\n--------------- volatile 关键字 ---------------");

        // 启动第一个子线程，当 flag=true 时自动停止
        new Thread(() -> visibilityVolatileInstance.run()).start();

        // 主线程休眠0.1秒
        ThreadService.delay(100);

        // 启动第二个子线程，修改全局标识符，停止第一个子线程
        new Thread(() -> visibilityVolatileInstance.shutdown()).start();
    }

    private static void synchronizedTest(VisibilitySynchronizedInstance synchronizedInstance) {

        System.out.println("\n--------------- synchronized 关键字 ---------------");

        // 启动第一个子线程，当 flag=true 时自动停止
        new Thread(() -> synchronizedInstance.run()).start();

        // 主线程休眠0.1秒
        ThreadService.delay(100);

        // 启动第二个子线程，修改全局标识符，停止第一个子线程
        new Thread(() -> synchronizedInstance.shutdown()).start();
    }

    private static void lockTest(VisibilityLockInstance lockInstance) {

        System.out.println("\n--------------- Lock 接口 ---------------");

        // 启动第一个子线程，当 flag=true 时自动停止
        new Thread(() -> lockInstance.run()).start();

        // 主线程休眠0.1秒
        ThreadService.delay(100);

        // 启动第二个子线程，修改全局标识符，停止第一个子线程
        new Thread(() -> lockInstance.shutdown()).start();
    }

    private static void atomicTest(VisibilityAtomicInstance atomicInstance) {

        System.out.println("\n--------------- Atomic 变量 ---------------");

        // 启动第一个子线程，当 flag=true 时自动停止
        new Thread(() -> atomicInstance.run()).start();

        // 主线程休眠0.1秒
        ThreadService.delay(100);

        // 启动第二个子线程，修改全局标识符，停止第一个子线程
        new Thread(() -> atomicInstance.shutdown()).start();
    }
}
