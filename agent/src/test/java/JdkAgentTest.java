import domain.Animal;
import domain.Dog;
import domain.DogAgent;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkAgentTest {

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

        Animal proxyInstance = (Animal) Proxy.newProxyInstance(
                dogClass.getClassLoader(),
                dogClass.getInterfaces(),
                new InvocationHandler() {
                    // 重写代理方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(">> dog's master is Tom");
                        method.invoke(dog, args);
                        return null;
                    }
                });
        proxyInstance.run();
        proxyInstance.eat();
    }
}
