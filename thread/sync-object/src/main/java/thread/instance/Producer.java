package thread.instance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Producer extends Thread {
    final List<String> msgList = new ArrayList<>();

    /**
     * 线程启动后便每隔3秒创建新消息
     */
    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                System.out.println("进入生产方法。。。");
                synchronized (msgList) {
                    Integer msg = new Random().nextInt(10);
                    System.out.println("生产新消息：" + msg);
                    // 将产生的消息放入消息列表，然后唤醒其他线程
                    msgList.add(msg.toString());
                    msgList.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取消息的方法，如果消息列表里没有消息则wait，等待被消息创建者的notify唤醒后再执行
     *
     * @return 消息
     */
    public String getMsg() {
        synchronized (msgList) {
            // 这里使用while和使用if虽然好像没什么区别，不过如果是if，则会触发IndexOutOfBound异常
            while (msgList.size() == 0) {
                try {
                    msgList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return msgList.remove(0);
        }
    }
}