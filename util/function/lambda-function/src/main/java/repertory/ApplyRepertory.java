package repertory;

import pojo.Apple;

import java.util.LinkedList;
import java.util.List;

public class ApplyRepertory {

    /**
     * 获取初始数据
     *
     * @return
     */
    public static List<Apple> getApples() {

        List<Apple> apples = new LinkedList<>();

        apples.add(new Apple(12.4f, "red"));
        apples.add(new Apple(11.6f, "pink"));
        apples.add(new Apple(13.2f, "green"));
        apples.add(new Apple(15.1f, "red"));

        return apples;
    }
}
