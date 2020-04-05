package domain;

public class Dog implements Animal {

    @Override
    public void run() {
        System.out.println("dog is running");
    }

    @Override
    public void eat() {
        System.out.println("dog eating meat");
    }
}
