package multi.instance;

public class BaseInstance {

    private int result = 0;

    protected static final int COUNT = 10000;

    public void increment() {
        for (int i = 0; i < COUNT; i++) {
            result++;
        }
    }

    public int getResult() {
        return result;
    }
}
