package thread;

public class RunnableInstance implements Runnable {

    @Override
    public void run() {
        System.out.println("This is thread name : " + Thread.currentThread().getName());
    }
}
