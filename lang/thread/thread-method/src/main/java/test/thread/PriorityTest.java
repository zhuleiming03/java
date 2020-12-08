package test.thread;

/**
 * thread.setPriority(priority)
 * 设置线程的优先级
 * <p>
 * thread.getPriority()
 * 获取线程的优先级
 * <p>
 * 优先级可设置 仅供参考 实际不一定能优先级高的先执行
 */
public class PriorityTest {

    public static void main(String[] args) {

        Runnable instance = () -> System.out.println(String.format("[%s]->[%s]",
                Thread.currentThread().getName(), Thread.currentThread().getPriority()));

        Thread one = new Thread(instance, "one");
        one.setPriority(1);

        Thread two = new Thread(instance, "two");
        two.setPriority(2);

        Thread six = new Thread(instance, "six");
        six.setPriority(6);

        six.start();
        two.start();
        one.start();
    }
}
