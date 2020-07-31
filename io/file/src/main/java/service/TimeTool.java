package service;

import java.io.IOException;

public interface TimeTool<R, A, B, C> {

    /**
     * 输入3个参数参数 返回 R
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    R apply(A a, B b, C c) throws IOException;
}
