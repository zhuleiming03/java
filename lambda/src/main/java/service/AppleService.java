package service;

import pojo.Apple;

import java.util.List;

public interface AppleService {

    /**
     * 遍历Apple数组
     *
     * @param apples
     * @param method
     * @return
     */
    List<Apple> appleFilter(List<Apple> apples, ApplePredicateService method);
}
