package service;

import java.util.function.Function;

public class InvokingFunctionService {

    public static <T, R> R apply(T t, Function<T, R> function) {
        return function.apply(t);
    }

    public static <T, V, R> R compose(T t, Function<T, V> one, Function<V, R> two) {
        return two.compose(one).apply(t);
    }

    public static <T, V, R> R andThen(T t, Function<T, V> one, Function<V, R> two) {
        return one.andThen(two).apply(t);
    }
}
