import org.junit.Test;
import pojo.Apple;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class MethodTest {

    /**
     * 执行反射类的方法
     */
    @Test
    public void method() {

        try {

            // 根据类名获取类的元数据
            String CLASS_NAME = "pojo.Apple";
            Class<?> appleClass = Class.forName(CLASS_NAME);

            // 根据构造函数获取一个类的实例
            Constructor<?> constructor = appleClass.getConstructor();
            Apple apple = (Apple) constructor.newInstance();

            // 反射执行私有方法
            Method method = appleClass.getDeclaredMethod("setPrice", BigDecimal.class);
            method.setAccessible(true);
            method.invoke(apple, new BigDecimal(10.5f));
            System.out.println(apple);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
