package service;

import java.util.function.Function;

public class FunctionService {

    public static <T, R> R test(T t, Function<T, R> function) {
        return function.apply(t);
    }
}
