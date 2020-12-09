package test.thread;

import thread.StopInstance;

/**
 * thread.stop()
 * 被弃用，采用折中方法实现线程停止
 */
public class StopTest {

    public static void main(String[] args) {

        // 创建线程
        StopInstance stopInstance = new StopInstance();
        Thread thread = new Thread(stopInstance);

        // 启动线程
        thread.start();

        // 0.2秒后停止线程
        try {
            Thread.sleep(200L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        stopInstance.setStop(true);
    }
}
