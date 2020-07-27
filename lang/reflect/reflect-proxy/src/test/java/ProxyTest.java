import org.junit.Test;
import pojo.Animal;
import pojo.Dog;
import pojo.DogAgent;

import java.lang.reflect.Proxy;

public class ProxyTest {

    /**
     * jdk 静态代理
     */
    @Test
    public void staticAgent() {
        DogAgent agent = new DogAgent(new Dog());
        agent.run();
        agent.eat();
    }

    /**
     * jdk 动态代理
     */
    @Test
    public void dynamicAgent() {
        Animal dog = new Dog();
        Class<?> dogClass = dog.getClass();

        // 重写代理方法
        Animal proxyInstance = (Animal) Proxy.newProxyInstance(
                dogClass.getClassLoader(),
                dogClass.getInterfaces(),
                (proxy, method, args) -> {
                    if ("run".equals(method.getName())) {
                        System.out.println(">> master open the door");
                    }
                    if ("eat".equals(method.getName())) {
                        System.out.println(">> master give dog meat");
                    }
                    method.invoke(dog, args);
                    return null;
                });
        proxyInstance.run();
        proxyInstance.eat();
    }
}
