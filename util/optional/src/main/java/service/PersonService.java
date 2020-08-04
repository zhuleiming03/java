package service;


import pojo.Person;

public class PersonService {

    public static int wheels(Person person) {
        return person.getCar().getWheels();
    }
}
