package multi.test.issue;

/**
 * 并发有序性测试
 * 有序性：即程序执行的顺序按照代码的先后顺序执行。
 * 在多线程场景下，由于指令重排会导致代码未按照预期顺序执行
 * 指令重排：CPU 执行单元的速度要远超主存访问速度。在执行程序时，为了提高性能，编译器和处理器会对指令做重排序。
 */
public class OrderingIssueTest {

    /**
     * 代码执行顺序先 param 赋值 后 flag 赋值 ，当出现指令重排的时候，另一个线程要正好CPU切换到指定代码处，会出现先 flag 赋值场景
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        int i = 0;

        do {
            Thread changeOne = new Thread(new Change());
            Thread init = new Thread(new Init());
            Thread changeTwo = new Thread(new Change());
            changeOne.start();
            init.start();
            changeTwo.start();
            init.join();
            restore();
            i++;
        } while (!stop);

        System.out.printf("第 %s 次循环时 flag : %s ; param : %s", i, flag, param);
    }

    private static void restore() {
        param = 0;
        flag = false;
    }

    public static class Init implements Runnable {
        @Override
        public void run() {
            // param 赋值
            param = 1;
            // flag 赋值
            flag = true;
        }
    }

    public static class Change implements Runnable {
        @Override
        public void run() {
            if (flag && param == 0) {
                // 发生指令重排场景（先对 flag 赋值 param 为默认值）时修改 stop
                stop = true;
            }
        }
    }

    private static int param = 0;
    private static boolean flag = false;
    private static boolean stop = false;
}
