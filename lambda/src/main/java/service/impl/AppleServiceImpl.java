package service.impl;

import pojo.Apple;
import service.ApplePredicateService;
import service.AppleService;

import java.util.LinkedList;
import java.util.List;

public class AppleServiceImpl implements AppleService {

    @Override
    public List<Apple> appleFilter(List<Apple> apples, ApplePredicateService method) {
        List<Apple> result = new LinkedList<>();
        for (Apple apple : apples) {
            if (method.filter(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
