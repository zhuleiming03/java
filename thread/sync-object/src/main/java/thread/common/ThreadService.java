package thread.common;

public class ThreadService {

    public static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
