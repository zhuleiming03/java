package test.thread;

/**
 * thread.getName()
 * 获取线程的名字。
 * <p>
 * thread.setName(name)
 * 设置线程的名字
 */
public class NameTest {

    public static void main(String[] args) {

        Thread instance = new Thread(() -> {
            System.out.println("当前线程-名字：" + Thread.currentThread().getName());
        });

        // 修改线程名称
        instance.setName("instance");

        instance.start();
    }
}
