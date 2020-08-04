package pojo;

public class User {

    private Car car;

    @Override
    public String toString() {
        return "User{" +
                "car=" + car +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
