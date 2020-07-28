package service.impl;

import pojo.Apple;
import service.ApplePredicateService;

public class ApplePredicateServiceImpl implements ApplePredicateService {

    private final static String COLOUR = "red";

    @Override
    public boolean filter(Apple apple) {
        return COLOUR.equals(apple.getColor());
    }
}
