package service;

import java.util.function.Predicate;

public class PredicateService {

    public static <T> boolean test(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }
}
