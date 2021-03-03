package multi.test.instance;

public class VolatileInstance {

    private volatile int volatileValue = 0;

    public void change(int value) {
        volatileValue = value;
        System.out.printf("Thread [%s] value changed 【%s】  \n", Thread.currentThread().getName(), value);
    }

    public void run() {
        System.out.printf("Thread [%s] running... volatile value【%s】 \n",
                Thread.currentThread().getName(), volatileValue);
        while (volatileValue == 0) {
        }
        System.out.printf("Thread [%s] running... volatile value【%s】 \n",
                Thread.currentThread().getName(), volatileValue);
        while (volatileValue == 1) {
        }
        System.out.printf("Thread [%s] running... volatile value【%s】 \n",
                Thread.currentThread().getName(), volatileValue);
        System.out.printf("Thread [%s] stop! \n", Thread.currentThread().getName());
    }
}
