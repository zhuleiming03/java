package thread.instance;

import thread.common.ThreadService;

import java.util.LinkedList;
import java.util.List;

public class CoffeeService {

    private final static Integer MAX_COUNT = 10;

    private static List<String> list = new LinkedList<>();

    public void consumer(Integer count) {
        synchronized (list) {
            boolean run = true;
            while (run) {
                if (list.size() < count) {
                    System.out.printf("当前咖啡库存【%2d】，             需要消费咖啡【%2d】，咖啡不足等待生产\n", list.size(), count);
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.printf("当前咖啡库存【%2d】，             消费咖啡【%2d】\n", list.size(), count);
                    if (count > 0) {
                        list.subList(0, count).clear();
                    }
                    System.out.printf("当前咖啡库存【%2d】，             消费咖啡结束\n", list.size());
                    list.notify();
                    run = false;
                }
            }
        }
    }

    public void producer() {
        while (true) {
            if (list.size() < MAX_COUNT) {
                synchronized (list) {
                    System.out.printf("当前咖啡库存【%2d】，准备咖啡\n", list.size());
                    list.add("coffee");
                    System.out.printf("当前咖啡库存【%2d】，生产咖啡完毕\n", list.size());
                    list.notify();
                }
                ThreadService.delay(500);
            } else {
                synchronized (list) {
                    try {
                        System.out.printf("当前咖啡库存【%2d】，停止生产咖啡\n", list.size());
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
