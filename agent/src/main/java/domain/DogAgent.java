package domain;

public class DogAgent implements Animal {

    private Dog dog;

    public DogAgent(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void run() {
        System.out.println(">> master open the door");
        dog.run();
    }

    @Override
    public void eat() {
        System.out.println(">> master give dog meat");
        dog.eat();
    }
}
