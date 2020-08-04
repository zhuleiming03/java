package service;

import pojo.Apple;

public class FruitService {

    public void println(Apple apple) {
        System.out.println(apple);
    }

    public Apple getCustomApple(Float weight, String color) {
        return new Apple(weight, color);
    }

    public static void getColor(Apple apple) {
        System.out.println(apple.getColor());
    }
}
