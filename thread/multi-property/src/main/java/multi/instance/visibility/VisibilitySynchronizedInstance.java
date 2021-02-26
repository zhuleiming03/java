package multi.instance.visibility;

/**
 * 通过synchronized关键字定义同步代码块或者同步方法保障可见性。
 */
public class VisibilitySynchronizedInstance extends VisibilityIssueInstance {

    private final byte[] obj = new byte[0];

    @Override
    public void shutdown() {
        synchronized (obj) {
            super.shutdown();
            obj.notify();
        }
    }

    @Override
    public void run() {
        synchronized (obj) {
            System.out.printf("Thread [%s] running...    flag【%s】 \n", Thread.currentThread().getName(), shutdown);
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            super.running();
            System.out.printf("Thread [%s] stop! \n", Thread.currentThread().getName());
        }
    }
}
