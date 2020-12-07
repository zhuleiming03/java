import org.junit.Test;
import thread.SlownessInstance;

public class DomainTest {

    public static void main(String[] args){
        // 非守护线程 即用户线程执行完后 进程才会结束
        Thread test = new Thread(new SlownessInstance(), "test");
        test.start();
    }

    @Test
    public void test() {
        // @Test 函数是不会等待子线程运行结束的,只要 @Test 函数执行结束就立即结束.
        // 所有junit user case 中的 @Test 函数 是依次执行的.
        Thread test = new Thread(new SlownessInstance(), "test");
        test.start();
    }
}
