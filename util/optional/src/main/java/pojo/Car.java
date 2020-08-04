package pojo;


public class Car {

    private int wheels;

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                '}';
    }

    public Car(int wheels) {
        this.wheels = wheels;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
}
