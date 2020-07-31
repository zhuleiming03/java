package service;

public class InvokingCustomService {

    public static <R, A, B, C, D> R test(CustomService<R, A, B, C, D> customService, A a, B b, C c, D d) {
        return customService.measure(a, b, c, d);
    }
}
