import common.Utils;
import thread.StopInstance;

public class StopTest {

    public static void main(String[] args) {

        // 创建线程
        StopInstance stopInstance = new StopInstance();
        Thread thread = new Thread(stopInstance);

        // 启动线程
        thread.start();

        // 2秒后停止线程
        Utils.delay(2);
        stopInstance.setStop(true);
    }
}
