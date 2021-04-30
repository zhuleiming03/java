package thread;

import thread.common.ThreadService;
import thread.instance.Coffee;
import thread.instance.CoffeeService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ObjectTest {

    public static void main(String[] args) {


        //testOne();
        testTwo();
    }


    private static void testTwo() {
        CoffeeService coffee = new CoffeeService();

        Thread p = new Thread(() -> coffee.producer());

        Thread c1 = new Thread(() -> coffee.consumer(2));

        Thread c2 = new Thread(() -> coffee.consumer(9));

        Thread c3 = new Thread(() -> coffee.consumer(1));

        Thread c4 = new Thread(() -> coffee.consumer(8));


        c1.start();

        ThreadService.delay(1200);
        p.start();

        ThreadService.delay(500);
        c2.start();

        ThreadService.delay(1000);

        c3.start();

        ThreadService.delay(7000);

        c4.start();

    }

    private static void testOne() {

        Coffee coffee = new Coffee();

        Thread c1 = new Thread(() -> coffee.consume(50));
        Thread c2 = new Thread(() -> coffee.consume(20));
        Thread c3 = new Thread(() -> coffee.consume(30));

        Thread p1 = new Thread(() -> coffee.produce(10));
        Thread p2 = new Thread(() -> coffee.produce(10));
        Thread p3 = new Thread(() -> coffee.produce(10));
        Thread p4 = new Thread(() -> coffee.produce(10));
        Thread p5 = new Thread(() -> coffee.produce(10));
        Thread p6 = new Thread(() -> coffee.produce(10));
        Thread p7 = new Thread(() -> coffee.produce(80));

        c1.start();
        c2.start();
        c3.start();

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}
