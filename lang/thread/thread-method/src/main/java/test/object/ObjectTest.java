package test.object;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

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
        //先让厨房多炒几个菜
        Thread.sleep(10000);
        //餐厅开始消费
        new Restaurant().start();
    }

    /**
     * 现有菜品
     */
    private static final Queue<String> FOOD_QUEUE = new LinkedList<>();

    /**
     * 菜品工具类
     **/
    public static class Foods {
        private static String[] foods = new String[]{"[鱼香肉丝]", "[水煮肉片]", "[地三鲜]", "[红烧肉]", "[干煸豆角]"};

        /**
         * 随机获取一个菜名
         *
         * @return
         */
        static String randomFood() {
            return foods[new Random().nextInt(foods.length)];
        }
    }

    /**
     * 厨房生产各种菜肴（wait、notify、synchronized）
     **/
    static class Kitchen extends Thread {
        @Override
        public void run() {
            while (true) {
                //加锁
                synchronized (FOOD_QUEUE) {
                    //菜架满了,厨房不必再茶菜,等着前厅通着再炒菜
                    //厨房的菜架能够存放菜品的最大值
                    int maxSize = 6;
                    if (maxSize == FOOD_QUEUE.size()) {
                        try {
                            System.out.println("厨房菜架满了,厨房不必再茶菜,等着前厅通着再炒菜,当前菜架:" + FOOD_QUEUE.toString());
                            FOOD_QUEUE.wait(111);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        //炒一个菜
                        String food = Foods.randomFood();
                        FOOD_QUEUE.add(food);
                        try {
                            System.out.println("厨房炒了一个:" + food + ",厨师歇息2分钟...当前菜架:" + FOOD_QUEUE.toString());
                            //抄完一个菜,歇息1分钟
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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
                synchronized (FOOD_QUEUE) {
                    //如果生意太好，菜品供不应求，只能等待厨房做菜...
                    if (0 == FOOD_QUEUE.size()) {
                        try {
                            System.out.println("餐厅：生意太好，菜品供不应求，只能等待厨房做菜...当前菜架:" + FOOD_QUEUE.toString());
                            FOOD_QUEUE.wait(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        //如果有菜，则消费菜品
                        //当厨房的储备菜品所剩不多时，告诉厨师开始炒菜
                        //当厨房还剩几个菜时，继续炒菜
                        int minSize = 2;
                        if (FOOD_QUEUE.size() <= minSize) {
                            FOOD_QUEUE.notify();
                            System.out.println("餐厅：厨房的储备菜品所剩不多时，厨师们该继续炒菜了...");
                        }
                        //消费菜品
                        String food = FOOD_QUEUE.poll();
                        try {
                            //随机一定时间吃掉一道菜
                            Thread.sleep(new Random().nextInt(1000) + 1500);
                            System.out.println("餐厅：刚刚消费了一道" + food + "...当前菜架:" + FOOD_QUEUE.toString());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
