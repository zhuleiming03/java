package service;

import java.util.function.Consumer;

public class InvokingConsumerService {

    public static <T> void accept(T t, Consumer<T> consumer) {
        consumer.accept(t);
    }

    public static <T> void andThen(T t, Consumer<T> one, Consumer<T> two) {
        one.andThen(two).accept(t);
    }
}
