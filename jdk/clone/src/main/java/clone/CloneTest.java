package clone;

import clone.pojo.User;

public class CloneTest {

    public static void main(String[] args) {
        baseClone();
    }

    private static void baseClone() {

        try {
            System.out.println(" Sean 是 Tom 的克隆体");
            User Tom = new User(1, "Tom");
            User Sean = Tom.clone();
            System.out.println("Tom :" + Tom);
            System.out.println("Sean :" + Sean);
            System.out.println(" Tom 修改属性 id");
            Tom.setId(2);
            System.out.println("Tom :" + Tom);
            System.out.println("Sean :" + Sean);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
