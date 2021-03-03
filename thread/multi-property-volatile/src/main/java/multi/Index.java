package multi;

import multi.test.instance.IssueInstance;
import multi.test.instance.VolatileInstance;

public class Index {

    // volatile 主要用于解决并发可见性问题
    // volatile 即易变的，在Java中标识一个变量是易变变量。
    // volatile 可以看成轻量级的 synchronized，相对于synchronized：编码简单、资源开销较少，同样的实现的功能也有限。
    // volatile 能够保证变量的可见性，但是并不能保证变量的原子性和有序性。
    // 使用volatile的前提，不受原子性和有序性影响：变量状态完全独立于任何程序的其他状态。

    public static void main(String[] args) {

        IssueInstance issueInstance = new IssueInstance();
        VolatileInstance volatileInstance = new VolatileInstance();

        // 启动第一个子线程，当【value】不等于默认值【0】时自动停止
        Thread issueThread = new Thread(() -> issueInstance.run());
        Thread volatileThread = new Thread(() -> volatileInstance.run());
        issueThread.setName("issue       run");
        volatileThread.setName("volatile    run");
        issueThread.start();
        volatileThread.start();

        // 主线程休眠1秒
        delay();

        // 启动第二个子线程，修改全局变量【value】的值为【1】
        // run-volatile 能获取到最新全局变量
        // run-issue 不能获取到最新全局变量
        Thread changeOneIssueThread = new Thread(() -> issueInstance.change(1));
        Thread changeOneVolatileThread = new Thread(() -> volatileInstance.change(1));
        changeOneIssueThread.setName("issue    change");
        changeOneVolatileThread.setName("volatile change");
        changeOneIssueThread.start();
        changeOneVolatileThread.start();

        // 主线程休眠1秒
        delay();

        // 启动第三个子线程，修改全局【value】的值为【2】
        // run-volatile 仍然能获取到最新全局变量，并结束
        // run-issue 依然不能获取到最新全局变量
        Thread changeTwoIssueThread = new Thread(() -> issueInstance.change(2));
        Thread changeTwoVolatileThread = new Thread(() -> volatileInstance.change(2));
        changeTwoIssueThread.setName("issue    change");
        changeTwoVolatileThread.setName("volatile change");
        changeTwoIssueThread.start();
        changeTwoVolatileThread.start();
    }

    private static void delay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
