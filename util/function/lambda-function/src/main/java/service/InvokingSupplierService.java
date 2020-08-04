package service;

import java.util.function.Supplier;

public class InvokingSupplierService {

    public static <T> T get(Supplier<T> supplier) {
        return supplier.get();
    }
}
