public class InstanceThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println(String.format("This is a son thread : %s No.%s",
                    Thread.currentThread().getName(), i));
            delay();
        }
    }

    public static void delay() {
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final Integer COUNT = 5;
}
