package pojo;

import java.util.Optional;

public class Person {

    private Optional<Car> car;

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }

    public Person() {
        car = Optional.empty();
    }

    public Car getCar() {
        return car.orElseGet(() -> new Car(0));
    }

    public void setCar(Car car) {
        this.car = Optional.ofNullable(car);
    }
}
