package multi.instance.visibility;

public class VisibilityIssueInstance {

    protected boolean shutdown = false;

    public void shutdown() {
        shutdown = true;
        System.out.printf("Thread [%s] flag changed  flag【%s】 \n", Thread.currentThread().getName(), shutdown);
    }

    public void run() {
        System.out.printf("Thread [%s] running...    flag【%s】 \n", Thread.currentThread().getName(), shutdown);
        running();
        System.out.printf("Thread [%s] stop! \n", Thread.currentThread().getName());
    }

    protected void running() {
        while (!shutdown) {
            //  可见性失效时永远无法停止
        }
    }
}
