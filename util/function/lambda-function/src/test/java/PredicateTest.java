import org.junit.Test;
import repertory.ApplyRepertory;
import service.InvokingPredicateService;


public class PredicateTest {

    @Test
    public void baseTest() {

        System.out.println("Apple 是红色：" +
                InvokingPredicateService.test(ApplyRepertory.getDefault(),
                        a -> COLOUR.equals(a.getColor())));
    }

    /**
     * 且
     */
    @Test
    public void andTest() {

        System.out.println("Apple 是红色且重量为 12.4 ：" +
                InvokingPredicateService.and(ApplyRepertory.getDefault(),
                        a -> COLOUR.equals(a.getColor()), a -> 12.4f == a.getWeight()));
    }

    /**
     * 非
     */
    @Test
    public void negateTest() {

        System.out.println("Apple 是红色 ：" +
                InvokingPredicateService.negate(ApplyRepertory.getDefault(),
                        a -> COLOUR.equals(a.getColor())));
    }

    /**
     * 或
     */
    @Test
    public void orTest() {

        System.out.println("Apple 是红色或重量为 12.4 ：" +
                InvokingPredicateService.or(ApplyRepertory.getDefault(),
                        a -> COLOUR.equals(a.getColor()), a -> 0.9f == a.getWeight()));

    }

    private final static String COLOUR = "red";
}
