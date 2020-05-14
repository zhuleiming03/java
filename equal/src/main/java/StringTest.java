public class StringTest {

    public static void main(String[] args) {

        System.out.println("------------- 常量池 --------------");

        //字面量放在常量池中
        String a = "Hello";
        System.out.println("字面量定义a 和字面量是同一个引用：" + (a == "Hello"));
        String a1 = "Hello";
        System.out.println("字面量定义a 和字面量定义a1 是同一个引用：" + (a == a1));

        System.out.println("------------ 堆 ------------------");

        //new 则放在堆中
        String b = new String("Hello");
        String b1 = new String("Hello");
        String b2 = b1;
        System.out.println("new 两个字符串 在堆中是两个引用：" + (b == b1));
        System.out.println("new 字符串可以传递引用：" + (b2 == b1));
        System.out.println("new 传递后字符串引用 和 new 字符串不是同一个引用：" + (b == b2));

        System.out.println("------------ 常量池和堆 ----------");

        System.out.println("new 字符串b 和字面量定义的a 不是一个引用：" + (a == b));

        System.out.println("------------ 相加计算 ------------");

        String c = a + " world";
        String c1 = "Hello world";
        System.out.println("字面量相加不等于字面量:" + (c == c1));

        String d = b + new String(" world");
        String d1 = new String("Hello world");
        System.out.println("new 字符串相加不等于 new字符串:" + (d == d1));
    }
}
