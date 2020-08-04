package service;

import java.util.function.BiFunction;
import java.util.function.Function;

public class InvokingBiFunctionService {

    public static <T, U, R> R apply(T t, U u, BiFunction<T, U, R> biFunction) {
        return biFunction.apply(t, u);
    }

    public static <T, U, R, V> V andThen(T t, U u, BiFunction<T, U, R> biFunction, Function<R, V> function) {
        return biFunction.andThen(function).apply(t, u);
    }
}
