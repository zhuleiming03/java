import org.junit.Test;
import pojo.Apple;
import repertory.ApplyRepertory;
import service.ApplePredicateService;
import service.impl.ApplePredicateServiceImpl;
import service.impl.AppleServiceImpl;

import java.util.List;

/**
 * 行为参数化 -> 匿名函数 -> lambda
 */
public class AppleTest {


    /**
     * 通过 行为参数化 实现
     * 需要接口（ApplePredicateService）和实例类（ApplePredicateServiceImpl）
     */
    @Test
    public void one() {

        List<Apple> apples = ApplyRepertory.getApples();

        System.out.println(String.format("苹果合计：%s 个", apples.size()));
        List<Apple> result = new AppleServiceImpl().appleFilter(apples, new ApplePredicateServiceImpl());
        System.out.println(String.format("筛选出：%s 个", result.size()));
        result.forEach(System.out::println);
    }

    /**
     * 通过 匿名类 实现
     * 需要接口（ApplePredicateService）和方法块（@Override）
     */
    @Test
    public void two() {

        List<Apple> apples = ApplyRepertory.getApples();

        System.out.println(String.format("苹果合计：%s 个", apples.size()));
        List<Apple> result = new AppleServiceImpl().appleFilter(apples, new ApplePredicateService() {
            @Override
            public boolean filter(Apple apple) {
                return GREEN.equals(apple.getColor());
            }
        });
        System.out.println(String.format("筛选出：%s 个", result.size()));
        result.forEach(System.out::println);
    }

    /**
     * 通过 lambda 实现
     * 需要接口（ApplePredicateService）和方法块 (Apple apple) -> "pink".equals(apple.getColor())
     */
    @Test
    public void three() {

        List<Apple> apples = ApplyRepertory.getApples();

        System.out.println(String.format("苹果合计：%s 个", apples.size()));
        List<Apple> result = new AppleServiceImpl().appleFilter(apples,
                (Apple apple) -> PINK.equals(apple.getColor()));
        System.out.println(String.format("筛选出：%s 个", result.size()));
        result.forEach(System.out::println);
    }

    private final static String PINK = "pink";

    private final static String GREEN = "green";
}
