package test.object;

import java.util.LinkedList;
import java.util.List;

public class ObjectTest {

    /**
     * 线程基本方法（sleep、wait、notify、notifyAll、synchronized）</p>
     **/
    public static void main(String[] args) throws InterruptedException {
        //通过关键字synchronized和Object的方法wait()/notify()/notifyAll()实现线程等待与唤醒
        //通过object.wait()，使得对象线程进行入等待唤醒状态，并释放对象上的锁
        //通过object.notify()/object.notifyALL()，唤醒此对象上等待的线程，并获得对象上的锁
        //wait()/notify()/notifyAll()必须在synchronized中使用
        new Kitchen().start();
        new Restaurant().start();
    }


    private static final List<Integer> DISH = new LinkedList<>();

    /**
     * 厨房生产各种菜肴（wait、notify、synchronized）
     **/
    static class Kitchen extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                synchronized (DISH) {
                    try {
                        int maxSize = 3;
                        if (maxSize == DISH.size()) {
                            System.out.println("Kitchen wait");
                            DISH.notify();
                            DISH.wait();
                        } else {
                            DISH.add(++i);
                            System.out.println("Kitchen i:" + i);
                            sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 餐厅消费各种菜肴（wait、notify、synchronized）
     **/
    static class Restaurant extends Thread {
        @Override
        public void run() {
            while (true) {
                //加锁
                synchronized (DISH) {
                    try {
                        if (0 == DISH.size()) {
                            System.out.println("Restaurant wait");
                            DISH.notify();
                            DISH.wait();
                        } else {
                            System.out.println("Restaurant i:" + DISH.get(0));
                            DISH.remove(0);
                            sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}
