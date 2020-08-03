package service;

import java.util.function.Predicate;

public class InvokingPredicateService {

    public static <T> boolean test(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    public static <T> boolean and(T t, Predicate<T> one, Predicate<T> two) {
        return one.and(two).test(t);
    }

    public static <T> boolean negate(T t, Predicate<T> one) {
        return one.negate().test(t);
    }

    public static <T> boolean or(T t, Predicate<T> one, Predicate<T> two) {
        return one.or(two).test(t);
    }
}
