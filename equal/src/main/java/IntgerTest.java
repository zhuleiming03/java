public class IntgerTest {

    public static void main(String[] args) {

        //a b 都取栈的常量池中值(小于128)
        System.out.println("--- 小于128的整数都取常量池中的值 ---");
        Integer a = 127;
        Integer b = 127;
        System.out.println("数值：" + (a.equals(b)));
        System.out.println("引用：" + (a == b));
        System.out.println(127 == a);

        //大于128都在堆中新建对象
        System.out.println("--- 大于128都在堆中新建对象 ---");
        Integer aa = 128;
        Integer bb = 128;
        System.out.println("数值：" + (aa.equals(bb)));
        System.out.println("引用：" + (aa == bb));

        //c d 都存在堆上
        System.out.println("--- new的值都在堆中新建对象 ---");
        Integer c = new Integer(6);
        Integer d = new Integer(6);
        System.out.println("数值：" + c.equals(d));
        System.out.println("引用：" + (c == d));
    }
}
