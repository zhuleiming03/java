package multi.test.instance;

public class IssueInstance {

    private int commonValue = 0;

    public void change(int value) {
        commonValue = value;
        System.out.printf("Thread [%s] value changed 【%s】  \n", Thread.currentThread().getName(), value);
    }

    public void run() {
        System.out.printf("Thread [%s] running... common   value【%s】 \n",
                Thread.currentThread().getName(), commonValue);
        while (commonValue == 0) {
        }
        System.out.printf("Thread [%s] stop! \n", Thread.currentThread().getName());
    }
}
