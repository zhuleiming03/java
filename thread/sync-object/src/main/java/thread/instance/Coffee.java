package thread.instance;

import java.util.LinkedList;
import java.util.List;

public class Coffee {

    private final static Integer MAX_COUNT = 100;

    private List<String> list = new LinkedList();

    public void produce(int num) {

        synchronized (list) {
            //仓库剩余的容量不足以存放即将要生产的数量，暂停生产
            while (list.size() + num > MAX_COUNT) {
                System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:"
                        + list.size() + "\t暂时不能执行生产任务!");

                try {
                    //条件不满足，生产阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < num; i++) {
                list.add("");
            }

            System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }

    public void consume(int num) {
        synchronized (list) {

            //不满足消费条件
            while (num > list.size()) {
                System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"
                        + list.size() + "\t暂时不能执行生产任务!");

                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //消费条件满足，开始消费
            if (num > 0) {
                list.subList(0, num).clear();
            }
            System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }
}
