package multi.instance;

import multi.common.ThreadService;

public class FieldInstance {

    private final byte[] lock = new byte[0];

    public synchronized void method() {
        System.out.printf("[%s] synchronized method begin \n", Thread.currentThread().getName());
        ThreadService.sleep(1000);
        System.out.printf("[%s] synchronized method end \n", Thread.currentThread().getName());
    }

    public void block() {
        System.out.printf("[%s] synchronized block begin \n", Thread.currentThread().getName());
        ThreadService.sleep(2000);
        System.out.printf("[%s] synchronized block\n", Thread.currentThread().getName());
        synchronized (lock) {
            ThreadService.sleep(1000);
        }
        System.out.printf("[%s] synchronized block end \n", Thread.currentThread().getName());
    }
}
