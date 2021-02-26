package multi.instance.visibility;

/**
 * 通过volatile关键字标记内存屏障保证可见性。
 */
public class VisibilityVolatileInstance extends VisibilityIssueInstance {

    private volatile boolean flag = false;

    @Override
    public void shutdown() {
        flag = true;
        System.out.printf("Thread [%s] flag changed  flag【%s】 \n", Thread.currentThread().getName(), flag);
    }

    @Override
    public void run() {
        System.out.printf("Thread [%s] running...    flag【%s】 \n", Thread.currentThread().getName(), flag);
        while (!flag) {
            //  可见性失效时永远无法停止
        }
        System.out.printf("Thread [%s] stop! \n", Thread.currentThread().getName());
    }
}
