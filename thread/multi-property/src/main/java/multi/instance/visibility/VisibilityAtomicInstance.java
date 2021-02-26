package multi.instance.visibility;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 通过Atomic类型保障可见性
 */
public class VisibilityAtomicInstance extends VisibilityIssueInstance {

    private AtomicBoolean flag = new AtomicBoolean(false);

    @Override
    public void shutdown() {
        flag.set(true);
        System.out.printf("Thread [%s] flag changed  flag【%s】 \n", Thread.currentThread().getName(), flag);
    }

    @Override
    public void run() {
        System.out.printf("Thread [%s] running...    flag【%s】 \n", Thread.currentThread().getName(), flag);
        while (!flag.get()) {
            //  可见性失效时永远无法停止
        }
        System.out.printf("Thread [%s] stop! \n", Thread.currentThread().getName());
    }
}
