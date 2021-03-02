package multi;

public class Index {

    // 并发三特性引发问题
    // 原子性(Atomicity)    引发修改值操作被覆盖问题 -> AtomicityIssueTest
    // 可见性(Visibility)   引发不能访问共享字段最新值的问题 -> VisibilityIssueTest
    // 有序性(Ordering)     引发操作顺序错乱问题 -> OrderingIssueTest

    //  并发三特性引发问题的解决方案
    //  特性	                volatile 关键字	synchronized 关键字	Lock 接口	Atomic 变量
    //  原子性(Atomicity)	    无法保障	    可以保障	        可以保障	可以保障
    //  可见性(Visibility)	    可以保障	    可以保障	        可以保障	可以保障
    //  有序性(Ordering)	    一定程度保障	可以保障	        可以保障	无法保障

}
