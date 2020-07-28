import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateTest {

    /**
     * 创建整数 stream
     */
    @Test
    public void intStream() {
        int[] numbers = {6, 32, 53, 12};
        IntStream integerStream = Arrays.stream(numbers);
        integerStream.forEach(i -> System.out.print(i + " "));
    }

    /**
     * 通过 of 创建 stream
     */
    @Test
    public void of() {
        Stream<String> stringStream = Stream.of("Java 8", "C#", "Python");
        stringStream.forEach(i -> System.out.print(i + " "));
    }

    /**
     * rang 顺序产生整数 stream
     */
    @Test
    public void rang() {

        System.out.println("----------- rangeClosed 创建整数1到10（含10） -----------");
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(i + " "));

        System.out.println("\n----------- range 创建整数1到10（不含10） -----------");
        IntStream.range(1, 10).forEach(i -> System.out.print(i + " "));
    }

    /**
     * 迭代产生有序无线整数 stream
     */
    @Test
    public void iterate() {
        System.out.println("----------- iterate -----------");
        IntStream.iterate(2, n -> n * 2).limit(10).forEach(i -> System.out.print(i + " "));
    }

    /**
     * 产生随机无序 stream
     */
    @Test
    public void generate() {
        System.out.println("----------- generate -----------");
        Stream.generate(Math::random).limit(6).forEach(i -> System.out.print(i + " "));
    }
}
