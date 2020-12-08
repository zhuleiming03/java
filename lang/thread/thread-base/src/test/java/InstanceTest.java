import org.junit.Test;

public class InstanceTest {

    /**
     * 通过 Junit4 TestRunner 源码就可以看出，
     * 如果是单线程，当测试主线程执行结束后，不管子线程是否结束，都会回调TestResult的wasSuccessful方法，
     * 然后判断结果是成功还是失败，最后调用相应的System.exit()方法。
     * 大家都知道这个方法是用来结束当前正在运行中的java虚拟机，jvm都自身难保了，所以子线程也就对不住你咧...
     * @Test 函数是不会等待子线程运行结束的, 只要 @Test 函数执行结束就立即结束.
     * 所有junit user case 中的 @Test 函数 是依次执行的.
     * 所以 @Test 不建议做多线程测试
     */
    @Test
    public void threadTest() {
        Instance.test();
    }
}
