package multi.test.issue;

import multi.common.ThreadService;
import multi.instance.visibility.VisibilityIssueInstance;

/**
 * 并发可见性测试
 * 可见性：当一个线程修改了共享变量的值，其他线程能够看到修改的值。
 * 在多线程场景下，由于指令重排会导致并发共享变量的值不可见
 * 指令重排：CPU 执行单元的速度要远超主存访问速度。在执行程序时，为了提高性能，编译器和处理器会对指令做重排序。
 */
public class VisibilityIssueTest {

    /**
     * 多线程并发对共享对象做修改操作，
     * 第一个子线程捕获到共享对象的修改值后停止运行，
     * 第二个子线程对共享对象的值进行修改，
     * 由于不符合不可性，导致第一个子线程获取不到修改后的值无法停止运行
     *
     * @param args
     */
    public static void main(String[] args) {

        VisibilityIssueInstance issueInstance = new VisibilityIssueInstance();

        // 启动第一个子线程，当 flag=true 时自动停止
        new Thread(() -> issueInstance.run()).start();

        // 主线程休眠0.1秒
        ThreadService.delay(100);

        // 启动第二个子线程，修改全局标识符，停止第一个子线程
        new Thread(() -> issueInstance.shutdown()).start();
    }
}
