import org.junit.Test;
import pojo.Apple;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BaseTest {

    /**
     * 获取反射类的基本信息
     */
    @Test
    public void baseInfo() {
        try {

            // 根据类名获取类的元数据
            String CLASS_NAME = "pojo.Apple";
            Class<?> appleClass = Class.forName(CLASS_NAME);

            // 根据类的元数据获取一个类的实例
            Apple apple = (Apple) appleClass.newInstance();

            // 类的实例也可以获取类的元数据
            System.out.println("实例和类元数据互转结果：" + (appleClass == apple.getClass()));

            // 通过类元数据获取类名
            System.out.println("获得类的完整名字: " + appleClass.getName());
            System.out.println("获得类的简单名字: " + appleClass.getSimpleName());
            System.out.println("获得类的包名: " + appleClass.getPackage());

            // 通过类元数据获取字段
            System.out.println("获得类的所有字段: ");
            Field[] fields = appleClass.getDeclaredFields();
            for (Field field : fields) {
                System.out.printf("字段名：【%s】,修饰符：【%s】,类型：%s \n",
                        field.getName(), Modifier.toString(field.getModifiers()), field.getGenericType());
            }

            // 通过类元数据获取方法
            System.out.println("获得类的所有方法: ");
            Method[] methods = appleClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.printf("方法名：【%s】，修饰符：【%s】 \n",
                        method.getName(), Modifier.toString(method.getModifiers()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
