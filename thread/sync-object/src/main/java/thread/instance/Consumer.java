package thread.instance;

public class Consumer extends Thread {
    private Producer producer;

    public Consumer(String name, Producer producer) {
        super(name);
        this.producer = producer;
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            String msg = producer.getMsg();
            System.out.println(Thread.currentThread().getName() + " 消费消息：" + msg);
            System.out.println();
        }
    }
}