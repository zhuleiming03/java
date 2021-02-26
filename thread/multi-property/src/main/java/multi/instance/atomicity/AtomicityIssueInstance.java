package multi.instance.atomicity;

public class AtomicityIssueInstance {

    private int count = 0;

    protected static final int COUNT = 10000;

    public void increment() {
        for (int i = 0; i < COUNT; i++) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
