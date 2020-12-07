package thread;

public class StopInstance implements Runnable {

    private Boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("running...");
        }
        System.out.println("stop!!!");
    }

    public void setStop(Boolean stop) {
        this.stop = stop;
    }
}
