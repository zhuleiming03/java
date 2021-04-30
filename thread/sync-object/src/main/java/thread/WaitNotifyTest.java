package thread;

import thread.instance.Consumer;
import thread.instance.Producer;

public class WaitNotifyTest {

    public static void main(String[] args) {
        // 一个生产者
        Producer producer = new Producer();
        producer.start();

        // 多个消费者共同消费
        new Consumer("1号消费者", producer).start();
        new Consumer("2号消费者", producer).start();
        new Consumer("3号消费者", producer).start();
    }
}
