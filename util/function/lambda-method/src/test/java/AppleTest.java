import org.junit.Test;
import pojo.Apple;
import service.AppleService;
import service.FruitService;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * java8方法引用有四种形式：
 * 静态方法引用　　　　　　　：　 　ClassName :: staticMethodName
 * 构造器引用　　　　　　　　：　 　ClassName :: new
 * 类的任意对象的实例方法引用：　 　ClassName :: instanceMethodName
 * 特定对象的实例方法引用　　：　 　object :: instanceMethodName
 */
public class AppleTest {

    @Test
    public void staticMethodNameTest() {
        List<Apple> apples = Arrays.asList(
                new Apple(16.5f, "green"),
                new Apple(14.5f, "red")
        );
        //apples.forEach(a -> FruitService.getColor(a));
        apples.forEach(FruitService::getColor);
    }

    @Test
    public void newTest() {

        //无参构造函数
        //Supplier<Apple> supplier = () -> new Apple();
        Supplier<Apple> supplier = Apple::new;
        System.out.println(supplier.get());

        //有参构造函数
        //Function<String, Apple> function = (color) -> new Apple(color);
        Function<String, Apple> function = Apple::new;
        System.out.println(function.apply("red"));
    }

    /**
     * 1、方法引用所使用方法的入参和返回值与lambda表达式实现的函数式接口的入参和返回值一致；
     * 2、lambda表达式的第一个入参为实例方法的调用者，后面的入参与实例方法的入参一致。
     */
    @Test
    public void instanceMethodNameTest() {
        Apple apple = new Apple(16.5f, "green");
        System.out.println(apple);
        //AppleService appleService = (f, w, c) -> f.getCustomApple(w, c);
        AppleService appleService = FruitService::getCustomApple;
        System.out.println(appleService.replace(new FruitService(), 17.5f, "red"));
    }

    @Test
    public void specialObjectTest() {
        List<Apple> apples = Arrays.asList(
                new Apple(16.5f, "green"),
                new Apple(14.5f, "red")
        );
        FruitService fruitService = new FruitService();
        //apples.forEach(a -> fruitService.println(a));
        apples.forEach(fruitService::println);
    }
}
