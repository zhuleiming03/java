import common.Utils;
import org.junit.Test;
import thread.RunnableInstance;
import thread.ThreadInstance;

/**
 * 启动线程
 */
public class StartTest {

    @Test
    public void threadTest() {

        ThreadInstance instance = new ThreadInstance();

        // run 还在主线程中执行 就是普通的方法调用
        instance.run();

        // start 创建子线程 再执行
        instance.start();
    }

    @Test
    public void runnableTest() {

        Thread rabbit = new Thread(new RunnableInstance(), "Rabbit");
        Thread tortoise = new Thread(new RunnableInstance(), "Tortoise");

        rabbit.start();
        tortoise.start();

        Utils.delay(1L);
    }
}
