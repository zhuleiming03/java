package multi.instance;

public class IssueInstance {

    private static int count = 0;

    private static final int COUNT = 10000;

    public void increment() {
        for (int i = 0; i < COUNT; i++) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
