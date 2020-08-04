import org.junit.Test;
import pojo.Car;
import pojo.Person;
import service.PersonService;

public class OptionalTest {

    @Test
    public void personTest() {

        Person person = new Person();
        System.out.println("car not exist, default wheels: " + PersonService.wheels(person));

        person.setCar(null);
        System.out.println("set a null car, wheels: " + PersonService.wheels(person));

        Car car = new Car(4);
        person.setCar(car);
        System.out.println("set a new car, wheels: " + PersonService.wheels(person));
    }
}
