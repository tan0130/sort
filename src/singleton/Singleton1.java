package singleton;

/**
 * create by tan on 2018/6/13
 * 方式二：饿汉式单例
 * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的。
 **/
// 饿汉式单例类，在类初始化时，已经自行实例化
public class Singleton1 {
    private Singleton1() {}
    private static final Singleton1 singleton = new Singleton1();
    // 静态工厂方法
    public static Singleton1 getInstance() {
        return singleton;
    }
}
